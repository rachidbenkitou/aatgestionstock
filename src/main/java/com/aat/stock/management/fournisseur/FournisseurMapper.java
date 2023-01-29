package com.aat.stock.management.fournisseur;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.filiere.FiliereDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FournisseurMapper {

    Fournisseur dtoToModel(FournisseurDto fournisseurDto);

    FournisseurDto modelToDto(Fournisseur fournisseur);

    List<FournisseurDto> modelToDtos(List<Fournisseur> fournisseurs);

}
