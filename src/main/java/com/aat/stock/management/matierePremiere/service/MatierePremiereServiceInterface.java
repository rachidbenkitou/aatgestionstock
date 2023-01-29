package com.aat.stock.management.matierePremiere.service;

import com.aat.stock.management.matierePremiere.MatierePremiereDto;

import java.util.List;

public interface MatierePremiereServiceInterface {

    List<MatierePremiereDto> MatierePremierefindAll();

    MatierePremiereDto MatierePremierefindById(String code);

    MatierePremiereDto MatierePremieresave(MatierePremiereDto matierePremiereDto);

    MatierePremiereDto MatierePremiereupdate(MatierePremiereDto matierePremiereDto);

    void MatierePremieredelete(String code);

}
