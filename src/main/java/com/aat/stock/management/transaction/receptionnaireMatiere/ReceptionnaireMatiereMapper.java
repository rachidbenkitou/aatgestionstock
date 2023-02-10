package com.aat.stock.management.transaction.receptionnaireMatiere;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceptionnaireMatiereMapper {
    ReceptionnaireMatiere dtoToModel(ReceptionnaireMatiereDto receptionnaireMatiereDto);
    ReceptionnaireMatiereDto modelToDto(ReceptionnaireMatiere receptionnaireMatiere);
    List<ReceptionnaireMatiereDto> modelToDtos(List<ReceptionnaireMatiere> receptionnaireMatieres);
}
