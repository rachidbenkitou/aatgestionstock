package com.aat.stock.management.intervenant.service;

import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.intervenant.IntervenantDto;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;

import java.util.List;

public interface IntervenantServiceInterface {
    public List<IntervenantDto> intervenantList();

    FournisseurDto fournisseurSave(FournisseurDto fournisseurDto);

    FournisseurDto fournisseurUpdate(FournisseurDto fournisseurDto);

    ReceptionnaireDto receptionnaireSave(ReceptionnaireDto receptionnaireDto);

    ReceptionnaireDto receptionnaireUpdate(ReceptionnaireDto receptionnaireDto);

    IntervenantDto intervenantFindById(Long id);

    void intervenantDelete(Long id);
}
