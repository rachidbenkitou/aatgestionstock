package com.aat.stock.management.fournisseur.service;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.fournisseur.FournisseurMapper;
import com.aat.stock.management.fournisseur.FournisseurRepository;
import com.aat.stock.management.fournisseur.exceptions.FournisseurNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FournisseurServiceImpl implements FournisseurServiceInter{

    @Autowired
    private FournisseurRepository fournisseurRepository;
    @Autowired
    private FournisseurMapper fournisseurMapper;
    @Override
    public List<FournisseurDto> findAllFournisseurs() {
        return fournisseurRepository.findAll().stream()
                .map(fournisseurMapper::modelToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FournisseurDto findFournisseurById(short id) {
        return fournisseurRepository.findById(id)
                .map(fournisseurMapper::modelToDto)
                .orElseThrow(() -> new FournisseurNotFoundException("Fournisseur with id: " + id + " not found."));
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return null;
    }

    @Override
    public FournisseurDto update(FournisseurDto fournisseurDto) {
        return null;
    }

    @Override
    public void delete(Short id) {

    }
}
