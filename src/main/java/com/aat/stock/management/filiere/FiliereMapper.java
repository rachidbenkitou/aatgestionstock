package com.aat.stock.management.filiere;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FiliereMapper {
    Filiere dtoToModel(FiliereDto filiereDto);

    FiliereDto modelToDto(Filiere filiere);

    List<FiliereDto> modelToDtos(List<Filiere> filieres);

}
