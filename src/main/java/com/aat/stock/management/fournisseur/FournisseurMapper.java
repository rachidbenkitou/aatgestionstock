package com.aat.stock.management.fournisseur;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FournisseurMapper {
    Fournisseur dtoToModel(FournisseurDto fournisseurDto);

    FournisseurDto modelToDto(Fournisseur fournisseur);

    List<FournisseurDto> modelToDtos(List<Fournisseur> fournisseurs);
}
