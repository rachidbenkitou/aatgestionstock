package com.aat.stock.management.matierePremiere;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.filiere.FiliereDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatierePremiereMapper {

    MatierePremiere dtoToModel(MatierePremiereDto matierePremiereDto);

    MatierePremiereDto modelToDto(MatierePremiere matierePremiere);

    List<MatierePremiereDto> modelToDtos(List<MatierePremiere> matierePremieres);

}
