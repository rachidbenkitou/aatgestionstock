package com.aat.stock.management.fournisseur.service;

import com.aat.stock.management.fournisseur.FournisseurDto;

import java.util.List;

public interface FournisseurServiceInterface {
    public List<FournisseurDto> listFournisseur();
    FournisseurDto fournisseurSave(FournisseurDto fournisseurDto);
    FournisseurDto updateFournisseur(FournisseurDto fournisseurDto);
    List<FournisseurDto> findFournisseurByIce(String ice);
    void deleteFournisseur(String ice);
}
