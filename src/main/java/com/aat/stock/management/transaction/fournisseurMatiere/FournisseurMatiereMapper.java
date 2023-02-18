package com.aat.stock.management.transaction.fournisseurMatiere;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface FournisseurMatiereMapper {
    FournisseurMatiere dtoToModel(FournisseurMatiereDto fournisseurMatiereDto);
    FournisseurMatiereDto modelToDto(FournisseurMatiere fournisseurMatiere);
    List<FournisseurMatiereDto> modelToDtos(List<FournisseurMatiere> fournisseurMatieres);

}
