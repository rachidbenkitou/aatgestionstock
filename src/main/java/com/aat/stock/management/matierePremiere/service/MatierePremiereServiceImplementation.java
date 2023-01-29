package com.aat.stock.management.matierePremiere.service;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import com.aat.stock.management.matierePremiere.MatierePremiereMapper;
import com.aat.stock.management.matierePremiere.MatierePremiereRepository;
import com.aat.stock.management.matierePremiere.exceptions.CodeMatierePremiereNotProvided;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereAlreadyExistsException;
import com.aat.stock.management.matierePremiere.exceptions.MatierePremiereNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatierePremiereServiceImplementation implements MatierePremiereServiceInterface{
    @Autowired
    private MatierePremiereRepository matierePremiereRepository;
    @Autowired
    private MatierePremiereMapper matierePremiereMapper;
    @Override
    public List<MatierePremiereDto> MatierePremierefindAll() throws MatierePremiereNotFoundException{
        Optional<List<MatierePremiere>> matierePremieres = Optional.ofNullable(matierePremiereRepository.findAll());
        return matierePremieres.map(matierePremiereMapper::modelToDtos)
                .orElseThrow(() -> new MatierePremiereNotFoundException("Aucune matière trouvée."));
    }
    @Override
    public MatierePremiereDto MatierePremierefindById(String code) {
        isCodeMatierePremiereExists(code);
        return matierePremiereRepository.findById(code)
                .map(matierePremiereMapper::modelToDto)
                .orElseThrow(() -> new MatierePremiereNotFoundException("Cette matière n'existe pas."));
    }


    @Override
    public MatierePremiereDto MatierePremieresave(MatierePremiereDto matierePremiereDto) {
        Optional<MatierePremiere> existingMatierePremiere = Optional.ofNullable(matierePremiereRepository.findMatierePremiereByDesignation(matierePremiereDto.getDesignation()));
        if(existingMatierePremiere.isPresent())
            throw new MatierePremiereAlreadyExistsException("Cette matière première avec cette desination existe déja dans la base de données.");
        else {
            MatierePremiere matierePremiere= matierePremiereMapper.dtoToModel(matierePremiereDto);
            //matierePremiere.setCode(UUID.randomUUID().toString().substring(0, 10));
            return matierePremiereMapper.modelToDto(matierePremiereRepository.save(matierePremiere));
        }
    }

    @Override
    public MatierePremiereDto MatierePremiereupdate(MatierePremiereDto matierePremiereDto) {
        isCodeMatierePremiereExists(matierePremiereDto.getCode());
        Optional<MatierePremiere> existingMatierePremiere = matierePremiereRepository.findById(matierePremiereDto.getCode());
        isMatierePremiereExists(matierePremiereDto.getCode());
        isCodeMatierePremiereExists(matierePremiereDto.getCode());
        MatierePremiere matierePremiere= matierePremiereMapper.dtoToModel(matierePremiereDto);
        return matierePremiereMapper.modelToDto(matierePremiereRepository.save(matierePremiere));
    }
    @Override
    public void MatierePremieredelete(String code) {
        isCodeMatierePremiereExists(code);
        Optional<MatierePremiere> existingMatierePremiere = matierePremiereRepository.findById(code);
        isMatierePremiereExists(code);
        matierePremiereRepository.deleteById(code);
    }

    public void isMatierePremiereExists(String code){
        Optional<MatierePremiere> existingMatierePremiere = matierePremiereRepository.findById(code);
        if(!existingMatierePremiere.isPresent()) {
            throw new MatierePremiereNotFoundException("La matière première avec ce code n'existe pas.");
        }
    }

    public void isCodeMatierePremiereExists(String code){
        if(code==null) {
            throw new CodeMatierePremiereNotProvided("Vous n'avez pas spécifié le code.");
        }
    }

}
