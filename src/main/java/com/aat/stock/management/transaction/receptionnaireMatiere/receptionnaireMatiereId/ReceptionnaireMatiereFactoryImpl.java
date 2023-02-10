package com.aat.stock.management.transaction.receptionnaireMatiere.receptionnaireMatiereId;

import org.springframework.stereotype.Service;

@Service
public class ReceptionnaireMatiereFactoryImpl implements ReceptionnaireMatiereFactory{
    @Override
    public ReceptionnaireMatiereId createReceptionnaireMatiereId(Long receptionnaireId, String matiereCode) {
        return new ReceptionnaireMatiereId(receptionnaireId,matiereCode);
    }
}
