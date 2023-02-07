package com.aat.stock.management.receptionnaire;

import com.aat.stock.management.receptionnaire.services.ReceptionnaireServiceIntr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receptionnaire")
public class ReceptionnaireController {
    @Autowired
    private ReceptionnaireServiceIntr receptionnaireServiceIntr;

    @GetMapping("/all")
    public ResponseEntity<List<ReceptionnaireDto>> findAllReceptionnaires() {
        return new ResponseEntity<>(receptionnaireServiceIntr.findAllReceptionnaires(), HttpStatus.OK);
    }
    @GetMapping("/find/{cne}")
    public ResponseEntity<ReceptionnaireDto> findReceptionnaireByCne(@PathVariable String cne) {
        return new ResponseEntity<>(receptionnaireServiceIntr.findReceptionnairesByCne(cne), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ReceptionnaireDto> saveReceptionnaire(@RequestBody ReceptionnaireDto receptionnaireDto){
        return new ResponseEntity<>(receptionnaireServiceIntr.saveReceptionnaires(receptionnaireDto), HttpStatus.CREATED);
    }
    @PostMapping("/update/{cne}")
    public ResponseEntity<ReceptionnaireDto> updateReceptionnaire(@PathVariable String cne ,@RequestBody ReceptionnaireDto receptionnaireDto){
        receptionnaireDto.setCne(cne);
        return new ResponseEntity<>(receptionnaireServiceIntr.saveReceptionnaires(receptionnaireDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{cne}")
    public ResponseEntity<?> deleteReceptionnaire(@PathVariable String cne){
        receptionnaireServiceIntr.deleteReceptionnaires(cne);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
