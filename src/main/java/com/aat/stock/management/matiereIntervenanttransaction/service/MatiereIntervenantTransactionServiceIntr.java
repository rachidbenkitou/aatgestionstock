package com.aat.stock.management.matiereIntervenanttransaction.service;

import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransactionDTO;

import java.util.List;

public interface MatiereIntervenantTransactionServiceIntr {


    List<MatiereIntervenantTransactionDTO> findAllTransaction();

    MatiereIntervenantTransactionDTO matiereSortie(MatiereIntervenantTransactionDTO matiereIntervenantTransactionDTO);
}
