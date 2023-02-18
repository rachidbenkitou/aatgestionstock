package com.aat.stock.management.filiere.service;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.filiere.FiliereDto;
import com.aat.stock.management.filiere.FiliereMapper;
import com.aat.stock.management.filiere.FiliereRepository;
import com.aat.stock.management.filiere.exceptions.FiliereAlreadyExistsException;
import com.aat.stock.management.filiere.exceptions.FiliereNotFoundException;
import com.aat.stock.management.filiere.exceptions.NomFiliereNotProvided;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import com.aat.stock.management.matierePremiere.MatierePremiereMapper;
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
    @Autowired
    private MatierePremiereMapper matierePremiereMapper;

    @Override
    public List<FiliereDto> findAllFiliers()throws FiliereNotFoundException {
        List <Filiere> filieres = filiereRepository.findAll();
        if(filieres == null) {
            throw new FiliereNotFoundException("aucun filiere est existe");
        }
        return filiereMapper.modelToDtos(filieres);
    }

    @Override
    public List<FiliereDto> findFiliereByNom(String nom) throws FiliereNotFoundException {
        isNomFiliereExists(nom);
        List <Filiere> filieres=filiereRepository.searchFiliere(nom);
        if(filieres == null) {
            throw new FiliereNotFoundException("ce filiere n'est pas existe");
        }

        return filiereMapper.modelToDtos(filieres);
    }

    @Override
    public List<MatierePremiereDto> findMatierePremieresByFiliereName(String nom) throws FiliereNotFoundException {
        isNomFiliereExists(nom);
        List<MatierePremiere> matierePremieres=filiereRepository.findMatierePremieresByFiliereName(nom);
        if(matierePremieres == null) {
            throw new FiliereNotFoundException("ce filiere n'est pas existe");
        }
        return matierePremiereMapper.modelToDtos(matierePremieres);
    }

    @Override
    public FiliereDto saveFiliere(FiliereDto filiereDto) throws FiliereAlreadyExistsException{
        // isFiliereExiste(filiereDto.getId());
        Filiere filiere = filiereMapper.dtoToModel(filiereDto);
        Filiere savedFiliere = filiereRepository.save(filiere);
        return filiereMapper.modelToDto(savedFiliere);


    }

    @Override
    public FiliereDto updateFiliere(FiliereDto filiereDto) throws FiliereNotFoundException{

            isFiliereNotExiste(filiereDto.getId());
            Filiere filiere = filiereMapper.dtoToModel(filiereDto);
            Filiere savedFiliere = filiereRepository.save(filiere);
            return filiereMapper.modelToDto(savedFiliere);

    }

    @Override
    public void deleteFiliere(Short id) throws FiliereNotFoundException,NomFiliereNotProvided{

        filiereRepository.deleteById(id);
    }

    public void  isFiliereExiste(Short id)throws FiliereAlreadyExistsException{
        Optional<Filiere> existingFiliere = filiereRepository.findById(id);
        if(existingFiliere.isPresent()) {
            throw new FiliereAlreadyExistsException("le filiere avec ce nom est deja existe ");
        }
    }
    public void  isFiliereNotExiste(Short id)throws FiliereNotFoundException{
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
