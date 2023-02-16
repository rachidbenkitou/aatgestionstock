package com.aat.stock.management.transaction.fournisseurMatiere.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.fournisseur.FournisseurRepository;
import com.aat.stock.management.fournisseur.exceptions.FournisseurNotFoundException;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import com.aat.stock.management.matierePremiere.MatierePremiereRepository;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereNotFoundException;
import com.aat.stock.management.matierePremiere.service.MatierePremiereServiceInterface;
import com.aat.stock.management.transaction.fournisseurMatiere.*;
import com.aat.stock.management.transaction.fournisseurMatiere.fournisseurMatiereId.FournisseurMatiereId;
import com.aat.stock.management.transaction.fournisseurMatiere.fournisseurMatiereId.FournisseurMatiereIdFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FournisseurMatiereServiceImpl implements FournisseurMatiereService{
    @Autowired
    private FournisseurMatiereRepository fournisseurMatiereRepository;
    @Autowired
    private MatierePremiereRepository matierePremiereRepository;
    @Autowired
    private MatierePremiereServiceInterface matierePremiereServiceInterface;
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private FournisseurMatiereMapper fournisseurMatiereMapper;
    @Autowired
    private FournisseurMatiereIdFactory fournisseurMatiereIdFactory;
    @Override
    public List<FournisseurMatiereDto> listFournisseurMatiere() {
        List <FournisseurMatiere> fournisseurMatieres = fournisseurMatiereRepository.findAll();
        return fournisseurMatiereMapper.modelToDtos(fournisseurMatieres);
    }

    @Override
    public List<FournisseurMatiereDto> listFournisseurMatiereByIce(String ice) {
        List <FournisseurMatiere> fournisseurMatieres =fournisseurMatiereRepository.findAllByFournisseurIce(ice);
        return fournisseurMatiereMapper.modelToDtos(fournisseurMatieres);
    }

    @Override
    public void deleteFournisseurMatiere(String ice) {
        fournisseurMatiereRepository.deleteAllByFournisseurIce(ice);
    }

    @Override
    public FournisseurMatiereDto saveFournisseurMatiere(FournisseurMatiereDto fournisseurMatiereDto) {
        MatierePremiere matierePremiere=matierePremiereRepository.findBycodeMatierePremiere(fournisseurMatiereDto.getArticleCode());
        if (matierePremiere==null) throw new MatierePremiereNotFoundException("La matière premiére n'existe pas.");
        Fournisseur fournisseur=fournisseurRepository.findByIce(fournisseurMatiereDto.getFournisseurIce());
        if (fournisseur==null) throw  new FournisseurNotFoundException("Le fournisseur n'existe pas.");
        fournisseurMatiereDto.setMatierePremiere(matierePremiere);
        fournisseurMatiereDto.setFournisseur(fournisseur);
        fournisseurMatiereDto.setConfirmed(false);
        FournisseurMatiereId fournisseurMatiereId=fournisseurMatiereIdFactory.createFournisseurMatiereId(fournisseur.getId(),matierePremiere.getCode());
        fournisseurMatiereDto.setFournisseurMatiereId(fournisseurMatiereId);
        FournisseurMatiere savedFournisseurMatiere=fournisseurMatiereRepository.save(fournisseurMatiereMapper.dtoToModel(fournisseurMatiereDto));

        return fournisseurMatiereMapper.modelToDto(savedFournisseurMatiere);
    }

    @Override
    public FournisseurMatiereDto updateFournisseurMatiere(FournisseurMatiereDto fournisseurMatiereDto) {
        FournisseurMatiere updatedFournisseurMatiere=fournisseurMatiereRepository.save(fournisseurMatiereMapper.dtoToModel(fournisseurMatiereDto));
        return fournisseurMatiereMapper.modelToDto(updatedFournisseurMatiere);
    }
    @Override
    public void isCofirmedFournisseurMatiere(String designation, short quantite) {
        MatierePremiereDto matierePremiereDto=matierePremiereServiceInterface.MatierePremierefindByDesignation(designation);
        matierePremiereDto.setStockActuel((short) (matierePremiereDto.getStockActuel()+quantite));
        matierePremiereServiceInterface.MatierePremiereupdate(matierePremiereDto);
    }
}
