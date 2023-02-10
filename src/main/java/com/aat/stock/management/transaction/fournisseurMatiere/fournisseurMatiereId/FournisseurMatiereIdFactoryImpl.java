package com.aat.stock.management.transaction.fournisseurMatiere.fournisseurMatiereId;

import org.springframework.stereotype.Service;

@Service
public class FournisseurMatiereIdFactoryImpl implements FournisseurMatiereIdFactory{
    @Override
    public FournisseurMatiereId createFournisseurMatiereId(Long fournisseurId, String matiereCode) {
        return  new FournisseurMatiereId(fournisseurId,matiereCode);
    }
}
