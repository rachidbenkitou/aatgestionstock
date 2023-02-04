package com.aat.stock.management.matiereIntervenanttransaction.service;

import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionDTO;

import java.util.List;

public interface MatiereIntervenantTransactionServiceIntr {

    MatiereIntervenantTransactionDTO saveMatiereIntervenantTransactionDTO(MatiereIntervenantTransactionDTO matiereIntervenantTransactionDTO);

    List<MatiereIntervenantTransactionDTO> listMatiereIntervenantTransactionDTO();

    List<MatiereIntervenantTransactionDTO> getAllIntervenantArticles();
}
