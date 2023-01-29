package com.aat.stock.management.filiere.service;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.filiere.FiliereDto;
import com.aat.stock.management.filiere.FiliereMapper;
import com.aat.stock.management.filiere.FiliereRepository;
import com.aat.stock.management.filiere.exceptions.FiliereAlreadyExistsException;
import com.aat.stock.management.filiere.exceptions.FiliereNotFoundException;
import com.aat.stock.management.filiere.exceptions.NomFiliereNotProvided;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.exceptions.CodeMatierePremiereNotProvided;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class FiliereServiceImpl implements FiliereServiceIntr {
    @Autowired
    private FiliereRepository filiereRepository;
    @Autowired
    private FiliereMapper filiereMapper;

    @Override
    public List<FiliereDto> findAllFiliers()throws FiliereNotFoundException {
        List <Filiere> filieres = filiereRepository.findAll();
        if(filieres == null) {
            throw new FiliereNotFoundException("aucun filiere est existe");
        }
        return filiereMapper.modelToDtos(filieres);
    }

    @Override
    public FiliereDto findFiliereById(String id) throws FiliereNotFoundException {
        isNomFiliereExists(id);
        Filiere filiere=filiereRepository.findById(id)
                .orElseThrow(()->new FiliereNotFoundException("ce filiere n'est pas existe"));
        return filiereMapper.modelToDto(filiere);
    }

    @Override
    public FiliereDto saveFiliere(FiliereDto filiereDto) throws FiliereAlreadyExistsException{
        isFiliereExiste(filiereDto.getNom());
        Filiere filiere = filiereMapper.dtoToModel(filiereDto);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.modelToDto(savedFiliere);


    }

    @Override
    public FiliereDto updateFiliere(FiliereDto filiereDto) throws FiliereNotFoundException{

            isFiliereNotExiste(filiereDto.getNom());
            Filiere filiere = filiereMapper.dtoToModel(filiereDto);
            Filiere savedFiliere = filiereRepository.save(filiere);
            return filiereMapper.modelToDto(savedFiliere);

    }

    @Override
    public void deleteFiliere(String id) throws FiliereNotFoundException,NomFiliereNotProvided{
          isNomFiliereExists(id);
          isFiliereNotExiste(id);
          filiereRepository.deleteById(id);
    }

    public void  isFiliereExiste(String id)throws FiliereAlreadyExistsException{
        Optional<Filiere> existingFiliere = filiereRepository.findById(id);
        if(existingFiliere.isPresent()) {
            throw new FiliereAlreadyExistsException("le filiere avec ce nom est deja existe ");
        }
    }
    public void  isFiliereNotExiste(String id)throws FiliereNotFoundException{
        Optional<Filiere> existingFiliere = filiereRepository.findById(id);
        if(!existingFiliere.isPresent()) {
            throw new FiliereNotFoundException("le filiere avec ce nom n'est pas existe ");
        }
    }
    public void isNomFiliereExists(String id) throws NomFiliereNotProvided{
        if(id==null) {
            throw new NomFiliereNotProvided("Vous n'avez pas spécifié le nom de filiere==id.");
        }
    }
}
