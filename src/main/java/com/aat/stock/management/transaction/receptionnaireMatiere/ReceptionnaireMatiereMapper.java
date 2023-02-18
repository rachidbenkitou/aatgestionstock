package com.aat.stock.management.transaction.receptionnaireMatiere;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface ReceptionnaireMatiereMapper {
    ReceptionnaireMatiere dtoToModel(ReceptionnaireMatiereDto receptionnaireMatiereDto);
    ReceptionnaireMatiereDto modelToDto(ReceptionnaireMatiere receptionnaireMatiere);
    List<ReceptionnaireMatiereDto> modelToDtos(List<ReceptionnaireMatiere> receptionnaireMatieres);
}
