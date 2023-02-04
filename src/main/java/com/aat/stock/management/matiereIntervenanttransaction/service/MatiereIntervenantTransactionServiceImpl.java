package com.aat.stock.management.matiereIntervenanttransaction.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.intervenant.IntervenantRepository;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionDTO;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionMapper;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionRepository;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereRepository;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatiereIntervenantTransactionServiceImpl implements MatiereIntervenantTransactionServiceIntr {
    @Autowired
    MatierePremiereRepository matierePremiereRepository;
    @Autowired
    IntervenantRepository intervenantRepository;
    @Autowired
    MatiereIntervenantTransactionRepository matiereIntervenantTransactionRepository;

    @Autowired
    MatiereIntervenantTransactionMapper matiereIntervenantTransactionMapper;
    @Override
    public MatiereIntervenantTransactionDTO saveMatiereIntervenantTransactionDTO(MatiereIntervenantTransactionDTO matiereIntervenantTransactionDTO) {
        Intervenant intervenant= null;
        if (matiereIntervenantTransactionDTO.getIntervenant() instanceof Receptionnaire) {
            Receptionnaire receptionnaire= (Receptionnaire) matiereIntervenantTransactionDTO.getIntervenant();
            intervenant = intervenantRepository.findByCne(receptionnaire.getCne());
        } else{
            Fournisseur fournisseur= (Fournisseur) matiereIntervenantTransactionDTO.getIntervenant();
            intervenant = intervenantRepository.findByIce(fournisseur.getIce());
        }

        MatierePremiere matierePremiere = matierePremiereRepository.findMatierePremiereByDesignation(matiereIntervenantTransactionDTO.getMatierePremiere().getDesignation());


        MatiereIntervenantTransaction matiereIntervenantTransaction = matiereIntervenantTransactionMapper.dtoToModel(matiereIntervenantTransactionDTO);
        matiereIntervenantTransaction.setIntervenant(intervenant);
        matiereIntervenantTransaction.setMatierePremiere(matierePremiere);


        MatiereIntervenantTransaction matiereIntervenantTransaction1 = matiereIntervenantTransactionRepository.save(matiereIntervenantTransaction);
        return matiereIntervenantTransactionMapper.modelToDto(matiereIntervenantTransaction1);
    }

    @Override
    public List<MatiereIntervenantTransactionDTO> listMatiereIntervenantTransactionDTO() {
        List <MatiereIntervenantTransaction> matiereIntervenantTransactions = matiereIntervenantTransactionRepository.findAll();
        return matiereIntervenantTransactionMapper.modelToDtos(matiereIntervenantTransactions);
    }

    @Override
    public List<MatiereIntervenantTransactionDTO> getAllIntervenantArticles() {
        List<MatiereIntervenantTransaction> intervenantArticles = matiereIntervenantTransactionRepository.findAll();
        return intervenantArticles.stream().map(matiereIntervenantTransactionMapper::modelToDto).collect(Collectors.toList());
    }
}
