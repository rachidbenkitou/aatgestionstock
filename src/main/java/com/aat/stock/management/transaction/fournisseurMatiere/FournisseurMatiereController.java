package com.aat.stock.management.transaction.fournisseurMatiere;

import com.aat.stock.management.transaction.fournisseurMatiere.service.FournisseurMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/transaction/entree")
@CrossOrigin("*")
public class FournisseurMatiereController {
    @Autowired
    private FournisseurMatiereService fournisseurMatiereService;
    @GetMapping("/all")
    public ResponseEntity<List<FournisseurMatiereDto>> fournisseurMatiereAll(){
        return new ResponseEntity<>(fournisseurMatiereService.listFournisseurMatiere(), HttpStatus.OK);
    }

    @GetMapping("/all-by-ice/{ice}")
    public ResponseEntity<List<FournisseurMatiereDto>> fournisseurMatiereAllByIce(@PathVariable String ice){
        return new ResponseEntity<>(fournisseurMatiereService.listFournisseurMatiereByIce(ice), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<FournisseurMatiereDto> saveFournisseurMatiere(@RequestBody FournisseurMatiereDto fournisseurMatiereDto){
        
        return  new ResponseEntity<>(fournisseurMatiereService.saveFournisseurMatiere(fournisseurMatiereDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<FournisseurMatiereDto> updateFournisseurMatiere(@RequestBody FournisseurMatiereDto fournisseurMatiereDto){
        return  new ResponseEntity<>(fournisseurMatiereService.updateFournisseurMatiere(fournisseurMatiereDto), HttpStatus.OK);
    }

    @PutMapping("/move-stock/{designation}/{quatite}")
    public ResponseEntity<?> updatestock(@PathVariable String designation, @PathVariable short quatite){
        fournisseurMatiereService.isCofirmedFournisseurMatiere(designation,quatite);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{ice}")
    public ResponseEntity<?> deleteFournisseurMatiere(@PathVariable String ice){
        fournisseurMatiereService.deleteFournisseurMatiere(ice);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
