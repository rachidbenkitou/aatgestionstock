package com.aat.stock.management.matierePremiere.service;

import com.aat.stock.management.matierePremiere.MatierePremiereDto;

import java.util.List;

public interface MatierePremiereServiceInterface {

    List<MatierePremiereDto> MatierePremierefindAll();

    List<MatierePremiereDto>  MatierePremierefindByCode(String code);
    MatierePremiereDto OneMatierePremierefindByCode(String code);
    MatierePremiereDto MatierePremierefindByDesignation(String designation);
    List<MatierePremiereDto> MatierePremierefindByDesign(String designation);
    MatierePremiereDto MatierePremieresave(MatierePremiereDto matierePremiereDto);

    MatierePremiereDto MatierePremiereupdate(MatierePremiereDto matierePremiereDto);

    void MatierePremieredelete(String code);

}
