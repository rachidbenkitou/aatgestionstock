package com.aat.stock.management.fournisseur.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.fournisseur.FournisseurMapper;
import com.aat.stock.management.fournisseur.FournisseurRepository;
import com.aat.stock.management.fournisseur.exceptions.FournisseurAlreadyExistsException;
import com.aat.stock.management.fournisseur.exceptions.FournisseurNotFoundException;
import com.aat.stock.management.fournisseur.exceptions.IceFournisseurNotProvided;
import com.aat.stock.management.receptionnaire.exceptions.ReceptionnaireNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FournisseurServiceImplementation implements FournisseurServiceInterface{
    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    FournisseurMapper fournisseurMapper;
    @Override
    public List<FournisseurDto> listFournisseur() {
        Optional<List<Fournisseur>> fournisseurs = Optional.ofNullable(fournisseurRepository.findAll());
        return fournisseurs.map(fournisseurMapper::modelToDtos)
                .orElseThrow(() -> new ReceptionnaireNotFoundException("Le fournisseur n'existe pas."));
    }
    @Override
    public List<FournisseurDto> findFournisseurByIce(String ice) {
        isIceExists(ice);
        Optional<List<Fournisseur>> fournisseur= Optional.ofNullable(fournisseurRepository.findByICE(ice));
        return fournisseur
                .map(fournisseurMapper::modelToDtos)
                .orElseThrow(() -> new FournisseurNotFoundException("Le fournisseur n'existe pas."));
    }
    @Override
    public FournisseurDto fournisseurSave(FournisseurDto fournisseurDto) {
        Optional<Fournisseur> existingFournisseur = Optional.ofNullable(fournisseurRepository
                .findByIce(fournisseurDto.getIce()));
        if(existingFournisseur.isPresent())
            throw new FournisseurAlreadyExistsException("Ce fournisseur existe déja dans la base de données.");
        else {
            Fournisseur fournisseur= fournisseurMapper.dtoToModel(fournisseurDto);
            return fournisseurMapper.modelToDto(fournisseurRepository.save(fournisseur));
        }
    }
    @Override
    public FournisseurDto updateFournisseur(FournisseurDto fournisseurDto) {
        isIceExists(fournisseurDto.getIce());
        isFournisseurExists(fournisseurDto.getIce());
        Fournisseur fournisseur= fournisseurMapper.dtoToModel(fournisseurDto);
        return fournisseurMapper.modelToDto(fournisseurRepository.save(fournisseur));
    }
    @Override
    public void deleteFournisseur(String ice) {
        isIceExists(ice);
        isFournisseurExists(ice);
        fournisseurRepository.deleteFournisseurByIce(ice);

    }
    public void isFournisseurExists(String ice){
        Optional<Fournisseur> existingFournisseur = Optional.ofNullable(fournisseurRepository.findByIce(ice));
        if(!existingFournisseur.isPresent()) {
            throw new FournisseurNotFoundException("Le fournisseuravec ce cne n'existe pas.");
        }
    }
    public void isIceExists(String ice){
        if(ice==null) {
            throw new IceFournisseurNotProvided("Vous n'avez pas spécifié l'ice'.");
        }
    }
}
