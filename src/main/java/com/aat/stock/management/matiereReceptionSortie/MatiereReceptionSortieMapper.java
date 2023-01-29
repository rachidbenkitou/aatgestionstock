package com.aat.stock.management.matiereReceptionSortie;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.filiere.FiliereDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MatiereReceptionSortieMapper {

    MatiereReceptionnaireSortie dtoToModel(MatiereReceptionnaireSortieDto matiereReceptionnaireSortieDto);

    MatiereReceptionnaireSortieDto modelToDto(MatiereReceptionnaireSortie matiereReceptionnaireSortie);

    List<MatiereReceptionnaireSortieDto> modelToDtos(List<MatiereReceptionnaireSortie> matiereReceptionnaireSorties);

}
