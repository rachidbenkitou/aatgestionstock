
package com.aat.stock.management.intervenant;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface IntervenantMapper {

    Fournisseur fournisseurDtoToModel(FournisseurDto fournisseurDto);

    FournisseurDto fournisseurModelToDto(Fournisseur fournisseur);

    List<FournisseurDto> fournisseurModelToDtos(List<Fournisseur> fournisseurs);

    Receptionnaire receptionnaireDtoToModel(ReceptionnaireDto receptionnaireDto);


    ReceptionnaireDto receptionnaireModelToDto(Receptionnaire receptionnaire);

    List<ReceptionnaireDto> receptionnaireModelToDtos(List<Receptionnaire> receptionnaires);

}
