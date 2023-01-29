package com.aat.stock.management.fournisseur;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fournisseurs")
@AllArgsConstructor
public class FournisseurController {

    /*
    private FournisseurServiceImpl fournisseurService;


    @GetMapping("/all")
    public ResponseEntity<List<FournisseurDto>> findAllFournisseurs(){

         fournisseurService.findAllContacts();

        return new  ResponseEntity<>(null, HttpStatus.OK);
    }

     */

}
