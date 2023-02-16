package com.aat.stock.management.matierePremiere;

import com.aat.stock.management.matierePremiere.service.MatierePremiereServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matiere-premiere")
@CrossOrigin("*")
public class MatierePremiereController {

    @Autowired
    private MatierePremiereServiceInterface matierePremiereServiceInterface;
    @GetMapping("/all")
    public ResponseEntity<List<MatierePremiereDto>> MatierePremiereFindAll(){
        return new ResponseEntity<>(matierePremiereServiceInterface.MatierePremierefindAll(), HttpStatus.OK);
    }

    @GetMapping(value = {"/find/code/{code}","/find"})
    public ResponseEntity<List<MatierePremiereDto>> MatierePremiereFindByCode(@PathVariable(required = false) String code){
        return new ResponseEntity<>(matierePremiereServiceInterface.MatierePremierefindByCode("%"+code+"%"), HttpStatus.OK);
    }

    @GetMapping(value = {"/find/design/{designation}","/find"})
    public ResponseEntity<List<MatierePremiereDto>> MatierePremiereFindByDesignation(@PathVariable(required = false) String designation){
        return new ResponseEntity<>(matierePremiereServiceInterface.MatierePremierefindByDesign("%"+designation+"%"), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<MatierePremiereDto> MatierePremiereSave(@RequestBody MatierePremiereDto matierePremiereDto){
        return new ResponseEntity<>(matierePremiereServiceInterface.MatierePremieresave(matierePremiereDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{designation}")
    public ResponseEntity<MatierePremiereDto> MatierePremiereUpdate(@PathVariable String designation,@RequestBody MatierePremiereDto matierePremiereDto) {
        matierePremiereDto.setDesignation(designation);
        return new ResponseEntity<>(matierePremiereServiceInterface.MatierePremiereupdate(matierePremiereDto),HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{code}","/delete"})
    //@DeleteMapping(value = { "/api/employeeswithrequiredfalse/{code}", "/api/employeeswithrequiredfalse" })
    @ResponseBody
    public ResponseEntity<?> MatierePremiereDelete(@PathVariable(required = false)  String code){
        matierePremiereServiceInterface.MatierePremieredelete(code);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
