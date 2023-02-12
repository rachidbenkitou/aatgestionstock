package com.aat.stock.management.fournisseur;

import com.aat.stock.management.fournisseur.service.FournisseurServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
@AllArgsConstructor
@CrossOrigin("*")
public class FournisseurController {
    @Autowired
    private FournisseurServiceInterface fournisseurServiceInterface;
    @GetMapping("/all")
    public ResponseEntity<List<FournisseurDto>> findAllFournisseurs() {
        return new ResponseEntity<>(fournisseurServiceInterface.listFournisseur(), HttpStatus.OK);
    }
    @GetMapping("/find/{ice}")
    public ResponseEntity<List<FournisseurDto>> findFournisseurByIce(@PathVariable String ice) {
        return new ResponseEntity<>(fournisseurServiceInterface.findFournisseurByIce("%"+ice+"%"), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<FournisseurDto> saveFournisseur(@RequestBody FournisseurDto fournisseurDto){
        return new ResponseEntity<>(fournisseurServiceInterface.fournisseurSave(fournisseurDto), HttpStatus.CREATED);
    }
    @PutMapping("/update/{ice}")
    public ResponseEntity<FournisseurDto> updateFournisseur(@PathVariable String ice ,@RequestBody FournisseurDto fournisseurDto){
        //fournisseurDto.setIce(ice);
        return new ResponseEntity<>(fournisseurServiceInterface.updateFournisseur(fournisseurDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{ice}")
    public ResponseEntity<?> deleteFournisseur(@PathVariable String ice){
        fournisseurServiceInterface.deleteFournisseur(ice);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
