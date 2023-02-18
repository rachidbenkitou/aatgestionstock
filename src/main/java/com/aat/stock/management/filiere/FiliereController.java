package com.aat.stock.management.filiere;

import com.aat.stock.management.filiere.service.FiliereServiceIntr;
import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filieres")
@CrossOrigin("*")
public class FiliereController {
    @Autowired
    private FiliereServiceIntr filiereService;
    @GetMapping("/all")
    public List<FiliereDto> listFilieres(){
        return  filiereService.findAllFiliers();
    }

    @GetMapping("/find/matieres-premieres-filiere/{nom}")
    public List<MatierePremiereDto> findMatierePremieresByFiliereName(@PathVariable(name="nom") String nom){
        return  filiereService.findMatierePremieresByFiliereName(nom);
    }
    @GetMapping("/find/{nom}")
    public List<FiliereDto> getFiliere(@PathVariable(name="nom") String nom){
        return  filiereService.findFiliereByNom("%"+nom+"%");
    }
    @PostMapping("/save")
    public FiliereDto saveFiliere(@RequestBody FiliereDto filiereDto){
        return  filiereService.saveFiliere(filiereDto);
    }
    @PutMapping("/update/{id}")
    public FiliereDto updateFiliere(@PathVariable(name = "id") Short id,@RequestBody FiliereDto filiereDto){
        filiereDto.setId(id);
        return  filiereService.updateFiliere(filiereDto);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteFiliere(@PathVariable(name = "id") Short id){

         filiereService.deleteFiliere(id);
    }
}
