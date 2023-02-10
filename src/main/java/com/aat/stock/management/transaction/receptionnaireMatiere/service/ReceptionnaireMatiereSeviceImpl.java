package com.aat.stock.management.transaction.receptionnaireMatiere.service;

import com.aat.stock.management.fournisseur.exceptions.FournisseurNotFoundException;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import com.aat.stock.management.matierePremiere.MatierePremiereRepository;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereNotFoundException;
import com.aat.stock.management.matierePremiere.service.MatierePremiereServiceInterface;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.receptionnaire.ReceptionnaireRepository;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiere;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiereDto;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiereMapper;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiereRepository;
import com.aat.stock.management.transaction.receptionnaireMatiere.exception.ReceptonnaireMatiereQuantityInsufisant;
import com.aat.stock.management.transaction.receptionnaireMatiere.receptionnaireMatiereId.ReceptionnaireMatiereFactory;
import com.aat.stock.management.transaction.receptionnaireMatiere.receptionnaireMatiereId.ReceptionnaireMatiereId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ReceptionnaireMatiereSeviceImpl implements ReceptionnaireMatiereService {
    @Autowired
    private ReceptionnaireMatiereRepository receptionnaireMatiereRepository;
    @Autowired
    private ReceptionnaireMatiereMapper receptionnaireMatiereMapper;
    @Autowired
    private MatierePremiereServiceInterface matierePremiereServiceInterface;

    @Autowired
    private MatierePremiereRepository matierePremiereRepository;
    @Autowired
    private ReceptionnaireRepository receptionnaireRepository;

    @Autowired
    private ReceptionnaireMatiereFactory receptionnaireMatiereFactory;

    @Override
    public ReceptionnaireMatiereDto saveReceptionnaireMatiere(ReceptionnaireMatiereDto receptionnaireMatiereDto) {
        short quatiteReste=matierePremiereServiceInterface.MatierePremierefindByDesignation(receptionnaireMatiereDto.getArticleDesignation()).getStockActuel();
        if(quatiteReste-receptionnaireMatiereDto.getQuantiteLivre()<0)
            throw new ReceptonnaireMatiereQuantityInsufisant("La quatité ets insuffisante, il reste que "+quatiteReste);
        MatierePremiere matierePremiere=matierePremiereRepository.findMatierePremiereByDesignation(receptionnaireMatiereDto.getArticleDesignation());
        if (matierePremiere==null) throw new MatierePremiereNotFoundException("La matière premiére n'existe pas.");
        Receptionnaire receptionnaire =receptionnaireRepository.findByCne(receptionnaireMatiereDto.getReceptionnaireCne());
        if (receptionnaire==null) throw  new FournisseurNotFoundException("Le fournisseur n'existe pas.");
        receptionnaireMatiereDto.setMatierePremiere(matierePremiere);
        receptionnaireMatiereDto.setReceptionnaire(receptionnaire);
        receptionnaireMatiereDto.setConfirmed(false);
        ReceptionnaireMatiereId receptionnaireMatiereId =receptionnaireMatiereFactory.createReceptionnaireMatiereId(receptionnaire.getId(),matierePremiere.getCode());
        receptionnaireMatiereDto.setReceptionnaireMatiereId(receptionnaireMatiereId);
        ReceptionnaireMatiere savedReceptionnaireMatiere=receptionnaireMatiereRepository.save(receptionnaireMatiereMapper.dtoToModel(receptionnaireMatiereDto));

        return receptionnaireMatiereMapper.modelToDto(savedReceptionnaireMatiere);

    }

    @Override
    public ReceptionnaireMatiereDto updateReceptionnaireMatiere(ReceptionnaireMatiereDto receptionnaireMatiereDto) {
        ReceptionnaireMatiere  updatedReceptionnaireMatiere=receptionnaireMatiereRepository.save(receptionnaireMatiereMapper.dtoToModel(receptionnaireMatiereDto));
        return receptionnaireMatiereMapper.modelToDto(updatedReceptionnaireMatiere);
    }

    @Override
    public void isCofirmedReceptionnaireMatiere(String designation, short quantite) {
        MatierePremiereDto matierePremiereDto=matierePremiereServiceInterface.MatierePremierefindByDesignation(designation);
        matierePremiereDto.setStockActuel((short) (matierePremiereDto.getStockActuel()-quantite));
        matierePremiereServiceInterface.MatierePremiereupdate(matierePremiereDto);

    }

    @Override
    public List<ReceptionnaireMatiereDto> listReceptionnaireMatiere() {
        List <ReceptionnaireMatiere> receptionnaireMatieres = receptionnaireMatiereRepository.findAll();
        return receptionnaireMatiereMapper.modelToDtos(receptionnaireMatieres);
    }

    @Override
    public List<ReceptionnaireMatiereDto> listReceptionnaireMatiereeByCne(String cne) {
        List <ReceptionnaireMatiere> receptionnaireMatieres = receptionnaireMatiereRepository.findAllByReceptionnaireCne(cne);
        return receptionnaireMatiereMapper.modelToDtos(receptionnaireMatieres);
    }

    @Override
    public void deleteReceptionnaireMatiere(String cne) {
        receptionnaireMatiereRepository.deleteAllByReceptionnaireCne(cne);
    }
}
