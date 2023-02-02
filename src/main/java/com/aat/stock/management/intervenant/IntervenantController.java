package com.aat.stock.management.intervenant;

import com.aat.stock.management.fournisseur.FournisseurDto;
import com.aat.stock.management.intervenant.service.IntervenantServiceInterface;
import com.aat.stock.management.receptionnaire.ReceptionnaireDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intervenant")
public class IntervenantController {
    @Autowired
    private IntervenantServiceInterface intervenantServiceInterface;
    @Autowired
    private IntervenantRepository intervenantRepository;

    @GetMapping("/all")
    public ResponseEntity<List<IntervenantDto>> IntervenantFindAll(){

        return new ResponseEntity<>(intervenantServiceInterface.intervenantList(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<IntervenantDto> intervenantFindById(@PathVariable Long id){
        return new ResponseEntity<>(intervenantServiceInterface.intervenantFindById(id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> intervenantDelete(@PathVariable Long id){
        intervenantServiceInterface.intervenantDelete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/fournisseur/save")
    public ResponseEntity<FournisseurDto> fournisseurSave(@RequestBody FournisseurDto fournisseurDto){

        return new ResponseEntity<>(intervenantServiceInterface.fournisseurSave(fournisseurDto), HttpStatus.CREATED);
    }

    @PutMapping("/fournisseur/update/{id}")
    public ResponseEntity<FournisseurDto> fournisseurUpdate(@PathVariable(name = "id") Long id,@RequestBody FournisseurDto fournisseurDto){
        fournisseurDto.setId(id);
        return new ResponseEntity<>(intervenantServiceInterface.fournisseurUpdate(fournisseurDto), HttpStatus.OK);
    }

    @PutMapping("/receptionnaire/update")
    public ResponseEntity<ReceptionnaireDto> receptionnaireSave(@RequestBody ReceptionnaireDto receptionnaireDto){

        return new ResponseEntity<>(intervenantServiceInterface.receptionnaireSave(receptionnaireDto), HttpStatus.OK);
    }




}
