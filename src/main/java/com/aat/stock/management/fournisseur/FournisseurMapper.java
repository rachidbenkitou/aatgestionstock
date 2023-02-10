package com.aat.stock.management.fournisseur;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface FournisseurMapper {
    Fournisseur dtoToModel(FournisseurDto fournisseurDto);

    FournisseurDto modelToDto(Fournisseur fournisseur);

    List<FournisseurDto> modelToDtos(List<Fournisseur> fournisseurs);
}
