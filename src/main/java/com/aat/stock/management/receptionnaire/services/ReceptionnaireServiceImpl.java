
package com.aat.stock.management.receptionnaire.services;

import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import com.aat.stock.management.receptionnaire.ReceptionnaireMapper;
import com.aat.stock.management.receptionnaire.ReceptionnaireRepository;
import com.aat.stock.management.receptionnaire.exceptions.CneReceptionnaireNotProvided;
import com.aat.stock.management.receptionnaire.exceptions.ReceptionnaireAlreadyExistsException;
import com.aat.stock.management.receptionnaire.exceptions.ReceptionnaireNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceptionnaireServiceImpl implements ReceptionnaireServiceIntr{
    @Autowired
    ReceptionnaireRepository receptionnaireRepository;
    @Autowired
    ReceptionnaireMapper receptionnaireMapper;

    @Override
    public List<ReceptionnaireDto> findAllReceptionnaires() {

        Optional<List<Receptionnaire>> receptionnaires = Optional.ofNullable(receptionnaireRepository.findAll());
        return receptionnaires.map(receptionnaireMapper::modelToDtos)
                .orElseThrow(() -> new ReceptionnaireNotFoundException("Le recéptionnaire n'existe pas."));
    }
    @Override
    public List<ReceptionnaireDto> findReceptionnairesByCne(String cne) {
        isCneExists(cne);
        Optional<List<Receptionnaire>> receptionnaires = Optional.ofNullable(receptionnaireRepository.findByCNE(cne));
        return receptionnaires
                .map(receptionnaireMapper::modelToDtos)
                .orElseThrow(() -> new ReceptionnaireNotFoundException("Le recéptionnaire n'existe pas."));
    }

    @Override
    public ReceptionnaireDto saveReceptionnaires(ReceptionnaireDto receptionnaireDto) {
        Optional<Receptionnaire> existingReceptionnaire = Optional.ofNullable(receptionnaireRepository
                .findByCne(receptionnaireDto.getCne()));
        if(existingReceptionnaire.isPresent())
            throw new ReceptionnaireAlreadyExistsException("Ce recéptionnaire existe déja dans la base de données.");
        else {
            Receptionnaire receptionnaire= receptionnaireMapper.dtoToModel(receptionnaireDto);
            return receptionnaireMapper.modelToDto(receptionnaireRepository.save(receptionnaire));
        }
    }

    @Override
    public ReceptionnaireDto updateReceptionnaires(ReceptionnaireDto receptionnaireDto) {
        isCneExists(receptionnaireDto.getCne());
        Optional<Receptionnaire> existingReceptionnaire = Optional.ofNullable(receptionnaireRepository.findByCne(receptionnaireDto.getCne()));
        isReceptionnaireExists(receptionnaireDto.getCne());
        Receptionnaire receptionnaire= receptionnaireMapper.dtoToModel(receptionnaireDto);
        return receptionnaireMapper.modelToDto(receptionnaireRepository.save(receptionnaire));
    }

    @Override
    public void deleteReceptionnaires(String cne) {

        isCneExists(cne);
        Optional<Receptionnaire> existingReceptionnaire = Optional.ofNullable(receptionnaireRepository.findByCne(cne));
        isReceptionnaireExists(cne);
        receptionnaireRepository.deleteByCne(cne);
    }

    public void isReceptionnaireExists(String cne){
        Optional<Receptionnaire> existingReceptionnaire = Optional.ofNullable(receptionnaireRepository.findByCne(cne));
        if(!existingReceptionnaire.isPresent()) {
            throw new ReceptionnaireNotFoundException("Le recéptionnaire avec ce cne n'existe pas.");
        }
    }
    public void isCneExists(String cne){
        if(cne==null) {
            throw new CneReceptionnaireNotProvided("Vous n'avez pas spécifié le cne.");
        }
    }
}

