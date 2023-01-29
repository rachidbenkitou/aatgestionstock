package com.aat.stock.management.intervenant.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.intervenant.IntervenantDto;
import com.aat.stock.management.intervenant.IntervenantMapper;
import com.aat.stock.management.intervenant.IntervenantRepository;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        for(Intervenant intervenant: intervenantRepository.findAll()){
            System.out.println(intervenant.getNom()+" "+intervenant.getEmail());
        }
        return intervenantRepository.findAll().stream()
                .map(intervenant -> {
                    if(intervenant instanceof Fournisseur) {
                        Fournisseur fournisseur = (Fournisseur) intervenant;
                        System.out.println(fournisseur.getTelephone());
                        System.out.println(intervenantMapper.fournisseurModelToDto(fournisseur).getTelephone());
                        return intervenantMapper.fournisseurModelToDto(fournisseur);
                    }
                    else {
                        Receptionnaire receptionnaire = (Receptionnaire) intervenant;
                        System.out.println(receptionnaire.getTelephone());
                        System.out.println(receptionnaire.getPrenom());
                        return intervenantMapper.receptionnaireModelToDto(receptionnaire);
                    }
                })
                .collect(Collectors.toList());
    }


}
