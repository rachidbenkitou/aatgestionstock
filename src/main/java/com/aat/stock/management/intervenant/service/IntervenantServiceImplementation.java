package com.aat.stock.management.intervenant.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.intervenant.IntervenantDto;
import com.aat.stock.management.intervenant.IntervenantMapper;
import com.aat.stock.management.intervenant.IntervenantRepository;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.exceptions.CodeMatierePremiereNotProvided;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereAlreadyExistsException;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereNotFoundException;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IntervenantServiceImplementation implements IntervenantServiceInterface{
    @Autowired
    private IntervenantRepository intervenantRepository;
    @Autowired
    private IntervenantMapper intervenantMapper;

    @Override
    public List<IntervenantDto> intervenantList(){
        List<Intervenant> intervenantList=intervenantRepository.findAll();
        List<IntervenantDto>intervenantDtos=new ArrayList<>();
        for(Intervenant intervenant:intervenantList){
            if(intervenant instanceof Fournisseur){
                Fournisseur fournisseur= (Fournisseur) intervenant;
                FournisseurDto fournisseurDto = intervenantMapper.fournisseurModelToDto(fournisseur);
                fournisseurDto.setType(fournisseur.getClass().getSimpleName());
                intervenantDtos.add(fournisseurDto);
            }
            else {
                Receptionnaire receptionnaire= (Receptionnaire) intervenant;
                ReceptionnaireDto receptionnaireDto =intervenantMapper.receptionnaireModelToDto(receptionnaire);
                receptionnaireDto.setType(receptionnaire.getClass().getSimpleName());
                intervenantDtos.add(receptionnaireDto);
            }

        }
        return intervenantDtos;
    }

    @Override
    public IntervenantDto intervenantFindById(Long id){
        Intervenant intervenant=intervenantRepository.findById(id)
                .orElseThrow(()->new MatierePremiereNotFoundException("L'intervenant n'existe pas."));

        if(intervenant instanceof Fournisseur){
            Fournisseur fournisseur=(Fournisseur) intervenant;
            FournisseurDto fournisseurDto1=intervenantMapper.fournisseurModelToDto(fournisseur);
            fournisseurDto1.setType(fournisseur.getClass().getSimpleName());
            return fournisseurDto1;
        } else{
            Receptionnaire receptionnaire=(Receptionnaire) intervenant;
            ReceptionnaireDto receptionnaireDto=intervenantMapper.receptionnaireModelToDto(receptionnaire);
            receptionnaireDto.setType(receptionnaire.getClass().getSimpleName());
            return  receptionnaireDto;
        }
    }
    @Override
    public void intervenantDelete(Long id){

        intervenantRepository.deleteById(id);
    }
    @Override
    public FournisseurDto fournisseurSave(FournisseurDto fournisseurDto) {
        Fournisseur fournisseur= intervenantMapper.fournisseurDtoToModel(fournisseurDto);
        return intervenantMapper.fournisseurModelToDto(intervenantRepository.save(fournisseur));
    }

    @Override
    public FournisseurDto fournisseurUpdate(FournisseurDto fournisseurDto) {
        Fournisseur fournisseur= intervenantMapper.fournisseurDtoToModel(fournisseurDto);
        Fournisseur savedFournosseur = intervenantRepository.save(fournisseur);
        FournisseurDto fournisseurDto1 = intervenantMapper.fournisseurModelToDto(savedFournosseur);
        fournisseurDto1.setType(savedFournosseur.getClass().getSimpleName());
        return fournisseurDto1;
    }

    @Override
    public ReceptionnaireDto receptionnaireSave(ReceptionnaireDto receptionnaireDto) {
        Receptionnaire receptionnaire= intervenantMapper.receptionnaireDtoToModel(receptionnaireDto);
        return intervenantMapper.receptionnaireModelToDto(intervenantRepository.save(receptionnaire));
    }

    @Override
    public ReceptionnaireDto receptionnaireUpdate(ReceptionnaireDto receptionnaireDto) {
        Receptionnaire receptionnaire= intervenantMapper.receptionnaireDtoToModel(receptionnaireDto);
        Receptionnaire savedReceptionnaire = intervenantRepository.save(receptionnaire);
        ReceptionnaireDto receptionnaireDto1=intervenantMapper.receptionnaireModelToDto(savedReceptionnaire);
        receptionnaireDto1.setType(savedReceptionnaire.getClass().getSimpleName());
        return receptionnaireDto1;
    }

    public void isIdIntervenantExists(Long id){
        if(id==null) {
            throw new CodeMatierePremiereNotProvided("Vous n'avez pas spécifié le id.");
        }
    }

}
