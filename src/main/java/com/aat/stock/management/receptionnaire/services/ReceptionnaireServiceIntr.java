package com.aat.stock.management.receptionnaire.services;

import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import com.aat.stock.management.receptionnaire.exceptions.ReceptionnaireNotFoundException;

import java.util.List;

public interface ReceptionnaireServiceIntr {

    List<ReceptionnaireDto> findAllReceptionnaires();


    ReceptionnaireDto findReceptionnairesById(Short id) throws ReceptionnaireNotFoundException;

    ReceptionnaireDto saveReceptionnaires(ReceptionnaireDto receptionnaireDto);

    ReceptionnaireDto updateReceptionnaires(ReceptionnaireDto receptionnaireDto);


    void deleteReceptionnaires(Short id);
}

