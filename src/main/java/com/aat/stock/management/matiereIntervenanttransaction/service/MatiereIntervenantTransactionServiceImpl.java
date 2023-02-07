package com.aat.stock.management.matiereIntervenanttransaction.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.matiereIntervenanttransaction.*;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatiereIntervenantTransactionServiceImpl implements MatiereIntervenantTransactionServiceIntr {
    @Autowired
    MatierePremiereRepository matierePremiereRepository;

    @Autowired
    MatiereIntervenantTransactionRepository matiereIntervenantTransactionRepository;

    @Autowired
    MatiereIntervenantTransactionMapper matiereIntervenantTransactionMapper;
    @Autowired
    private MatiereIntervenantTransactionRepository matiereIntervenantTransactionIdRepository;

    @Override
    public MatiereIntervenantTransactionDTO saveMatiereIntervenantTransactionDTO(MatiereIntervenantTransactionDTO matiereIntervenantTransactionDTO) {
        /*
        MatierePremiere matierePremiere=matierePremiereRepository.findMatierePremiereByDesignation(matiereIntervenantTransactionDTO.getArticleDesignation());
        Fournisseur fournisseur=intervenantRepository.findByIce(matiereIntervenantTransactionDTO.getIntervenantIce());
        MatiereIntervenantTransaction matiereIntervenantTransaction=matiereIntervenantTransactionMapper.dtoToModel(matiereIntervenantTransactionDTO);
        matiereIntervenantTransaction.setMatierePremiere(matierePremiere);
        matiereIntervenantTransaction.setIntervenant(fournisseur);
        MatiereIntervenantTransactionId matiereIntervenantTransactionId= new MatiereIntervenantTransactionId(fournisseur.getId(),matierePremiere.getDesignation());
        matiereIntervenantTransaction.setMatiereIntervenantTransactionId (matiereIntervenantTransactionId);
        MatiereIntervenantTransaction savedTransaction=matiereIntervenantTransactionRepository.save(matiereIntervenantTransaction);
        System.out.println(savedTransaction.getIntervenant().getEmail());
        System.out.println(savedTransaction.getMatierePremiere().getCode());




        return matiereIntervenantTransactionMapper.modelToDto(savedTransaction);

         */
        return null;

    }

    @Override
    public List<MatiereIntervenantTransactionDTO> listMatiereIntervenantTransactionDTO() {
        List <MatiereIntervenantTransaction> matiereIntervenantTransactions = matiereIntervenantTransactionRepository.findAll();
        return matiereIntervenantTransactionMapper.modelToDtos(matiereIntervenantTransactions);
    }

}


