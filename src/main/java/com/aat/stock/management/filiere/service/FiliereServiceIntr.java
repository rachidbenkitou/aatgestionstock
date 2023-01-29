package com.aat.stock.management.filiere.service;

import com.aat.stock.management.filiere.FiliereDto;
import com.aat.stock.management.filiere.exceptions.FiliereNotFoundException;

import java.util.List;

public interface FiliereServiceIntr {
    List<FiliereDto> findAllFiliers();


    FiliereDto findFiliereById(String id) throws FiliereNotFoundException;

    FiliereDto saveFiliere(FiliereDto  filiereDto);

    FiliereDto  updateFiliere(FiliereDto  filiereDto);


    void deleteFiliere(String id);
}
