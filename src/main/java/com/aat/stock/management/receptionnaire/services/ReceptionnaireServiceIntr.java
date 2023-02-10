package com.aat.stock.management.receptionnaire.services;

import com.aat.stock.management.receptionnaire.ReceptionnaireDto;

import java.util.List;

public interface ReceptionnaireServiceIntr {
    List<ReceptionnaireDto> findAllReceptionnaires();
    List<ReceptionnaireDto> findReceptionnairesByCne(String cne);
    ReceptionnaireDto saveReceptionnaires(ReceptionnaireDto receptionnaireDto);
    ReceptionnaireDto updateReceptionnaires(ReceptionnaireDto receptionnaireDto);
    void deleteReceptionnaires(String cne);
}

