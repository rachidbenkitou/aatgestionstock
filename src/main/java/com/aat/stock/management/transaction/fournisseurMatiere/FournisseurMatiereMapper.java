package com.aat.stock.management.transaction.fournisseurMatiere;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FournisseurMatiereMapper {
    FournisseurMatiere dtoToModel(FournisseurMatiereDto fournisseurMatiereDto);
    FournisseurMatiereDto modelToDto(FournisseurMatiere fournisseurMatiere);
    List<FournisseurMatiereDto> modelToDtos(List<FournisseurMatiere> fournisseurMatieres);

}
