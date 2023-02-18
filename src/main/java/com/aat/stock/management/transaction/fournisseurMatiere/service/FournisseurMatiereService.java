package com.aat.stock.management.transaction.fournisseurMatiere.service;

import com.aat.stock.management.transaction.fournisseurMatiere.FournisseurMatiereDto;

import java.util.List;

public interface FournisseurMatiereService {
    FournisseurMatiereDto saveFournisseurMatiere(FournisseurMatiereDto fournisseurMatiereDto);
    FournisseurMatiereDto updateFournisseurMatiere(FournisseurMatiereDto fournisseurMatiereDto);
    void isCofirmedFournisseurMatiere(String  designation, short quantite, Long idTransactionEntree);
    List<FournisseurMatiereDto> listFournisseurMatiere();
    List<FournisseurMatiereDto> listFournisseurMatiereByIce(String ice);
    void deleteFournisseurMatiere(Long id);
}
