package com.aat.stock.management.intervenant.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.intervenant.IntervenantDto;
import com.aat.stock.management.intervenant.IntervenantMapper;
import com.aat.stock.management.intervenant.IntervenantRepository;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntervenantServiceImplementation implements IntervenantServiceInterface{
    @Autowired
    private IntervenantRepository intervenantRepository;
    @Autowired
    private IntervenantMapper intervenantMapper;

    /*
    @Override
    public List<IntervenantDto> intervenantList(){
        List<Intervenant> intervenants= intervenantRepository.findAll();
        List<IntervenantDto> intervenantDtos= intervenants.stream().map(intervenant -> {
            if(intervenant instanceof Fournisseur){
                Fournisseur fournisseur=(Fournisseur) intervenant;
                return intervenantMapper.fournisseurModelToDto(fournisseur);
            }else{
                Receptionnaire receptionnaire =(Receptionnaire) intervenant;
                return  intervenantMapper.receptionnaireModelToDto(receptionnaire);
            }
        }).collect(Collectors.toList());

        return intervenantDtos;
    }

     */

    @Override
    public List<IntervenantDto> intervenantList(){
       /* return intervenantRepository.findAll().stream()
                .map(intervenant -> {
                    if(intervenant instanceof Fournisseur) {
                        Fournisseur fournisseur = (Fournisseur) intervenant;
                        return intervenantMapper.fournisseurModelToDto(fournisseur);
                    }
                    else {
                        Receptionnaire receptionnaire = (Receptionnaire) intervenant;
                        return intervenantMapper.receptionnaireModelToDto(receptionnaire);
                    }
                })
                .collect(Collectors.toList());

        */

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

}
