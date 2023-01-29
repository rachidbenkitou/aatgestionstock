package com.aat.stock.management.matiereFournisseurEntree;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.filiere.FiliereDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatiereFournisseurEntreeMapper {

    MatiereFournisseurEntree dtoToModel(MatiereFournisseurEntreeDto matiereFournisseurEntreeDto);

    MatiereFournisseurEntreeDto modelToDto(MatiereFournisseurEntree matiereFournisseurEntree);

    List<MatiereFournisseurEntreeDto> modelToDtos(List<MatiereFournisseurEntree> matiereFournisseurEntrees);

}
