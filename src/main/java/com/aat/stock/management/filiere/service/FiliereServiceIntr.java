package com.aat.stock.management.filiere.service;

import com.aat.stock.management.filiere.FiliereDto;
import com.aat.stock.management.filiere.exceptions.FiliereNotFoundException;
import com.aat.stock.management.matierePremiere.MatierePremiereDto;

import java.util.List;

public interface FiliereServiceIntr {
    List<FiliereDto> findAllFiliers();

    List<FiliereDto> findFiliereByNom(String nom) throws FiliereNotFoundException;

    List<MatierePremiereDto> findMatierePremieresByFiliereName(String nom) throws FiliereNotFoundException;

    FiliereDto saveFiliere(FiliereDto  filiereDto);

    FiliereDto  updateFiliere(FiliereDto  filiereDto);


    void deleteFiliere(Short id);
}
