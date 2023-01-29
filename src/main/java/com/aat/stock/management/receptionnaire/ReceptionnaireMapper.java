package com.aat.stock.management.receptionnaire;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.filiere.FiliereDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReceptionnaireMapper {

    Receptionnaire dtoToModel(ReceptionnaireDto receptionnaireDto);

    ReceptionnaireDto modelToDto(Receptionnaire receptionnaire);

    List<ReceptionnaireDto> modelToDtos(List<Receptionnaire> receptionnaires);

}


