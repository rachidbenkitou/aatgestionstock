package com.aat.stock.management.transaction.receptionnaireMatiere;

import com.aat.stock.management.transaction.receptionnaireMatiere.service.ReceptionnaireMatiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction/sortie")
@CrossOrigin("*")
public class ReceptionnaireMatiereController {
    @Autowired
    private ReceptionnaireMatiereService receptionnaireMatiereService;
    @GetMapping("/all")
    public ResponseEntity<List<ReceptionnaireMatiereDto>> fournisseurMatiereAll(){
        return new ResponseEntity<>(receptionnaireMatiereService.listReceptionnaireMatiere(), HttpStatus.OK);
    }
    @GetMapping("/all-by-cne/{cne}")
    public ResponseEntity<List<ReceptionnaireMatiereDto>> receptionnaireMatiereAllByCne(@PathVariable String cne){
        return new ResponseEntity<>(receptionnaireMatiereService.listReceptionnaireMatiereeByCne(cne), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ReceptionnaireMatiereDto> saveReceptionnaireMatiere(@RequestBody ReceptionnaireMatiereDto receptionnaireMatiereDto){
        return  new ResponseEntity<>(receptionnaireMatiereService.saveReceptionnaireMatiere(receptionnaireMatiereDto), HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ReceptionnaireMatiereDto> updateReceptionnaireMatiere(@RequestBody ReceptionnaireMatiereDto receptionnaireMatiereDto, @PathVariable Long id){
        receptionnaireMatiereDto.setIdTransactionSortie(id);
        return  new ResponseEntity<>(receptionnaireMatiereService.updateReceptionnaireMatiere(receptionnaireMatiereDto), HttpStatus.OK);
    }
    @PutMapping("/move-stock/{code}/{quatite}/{idTransactionSortie}")
    public ResponseEntity<?> updatestock(@PathVariable String code, @PathVariable short quatite, @PathVariable Long idTransactionSortie){
        receptionnaireMatiereService.isCofirmedReceptionnaireMatiere(code,quatite,idTransactionSortie);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReceptionnaireMatiere(@PathVariable Long id){
        receptionnaireMatiereService.deleteReceptionnaireMatiere(id);
        return new  ResponseEntity<>(HttpStatus.OK);
    }
}
