
package com.aat.stock.management.intervenant;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper(componentModel = "spring")
@Service
public interface IntervenantMapper {

    //Fournisseur fournisseurDtoToModel(FournisseurDto fournisseurDto);

    IntervenantDto fournisseurModelToDto(Fournisseur fournisseur);

    //List<FournisseurDto> fournisseurModelToDtos(List<Fournisseur> fournisseurs);

    //Receptionnaire receptionnaireDtoToModel(ReceptionnaireDto receptionnaireDto);

    IntervenantDto receptionnaireModelToDto(Receptionnaire receptionnaire);

    //List<ReceptionnaireDto> receptionnaireModelToDtos(List<Receptionnaire> receptionnaires);

}
