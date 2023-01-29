package com.aat.stock.management.fournisseur.service;

import com.aat.stock.management.fournisseur.FournisseurDto;

import java.util.List;

public interface FournisseurServiceInter {
    List<FournisseurDto> findAllFournisseurs();
    FournisseurDto findFournisseurById(short id);
    FournisseurDto save(FournisseurDto fournisseurDto);
    FournisseurDto update(FournisseurDto fournisseurDto);
    void delete(Short id);

}
