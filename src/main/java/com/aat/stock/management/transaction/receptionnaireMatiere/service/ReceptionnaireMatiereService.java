package com.aat.stock.management.transaction.receptionnaireMatiere.service;

import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiereDto;

import java.util.List;

public interface ReceptionnaireMatiereService {
    ReceptionnaireMatiereDto saveReceptionnaireMatiere(ReceptionnaireMatiereDto receptionnaireMatiereDto);
    ReceptionnaireMatiereDto updateReceptionnaireMatiere(ReceptionnaireMatiereDto receptionnaireMatiereDto);
    void isCofirmedReceptionnaireMatiere(String  designation, short quantite, Long idTransactionSortie);
    List<ReceptionnaireMatiereDto> listReceptionnaireMatiere();
    List<ReceptionnaireMatiereDto> listReceptionnaireMatiereeByCne(String cne);
    void deleteReceptionnaireMatiere(Long id);
}
