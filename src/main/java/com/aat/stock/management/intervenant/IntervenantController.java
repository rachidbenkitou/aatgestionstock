package com.aat.stock.management.intervenant;

import com.aat.stock.management.intervenant.service.IntervenantServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/intervenant")
public class IntervenantController {
    @Autowired
    private IntervenantServiceInterface intervenantServiceInterface;

    @GetMapping("/all")
    public ResponseEntity<List<IntervenantDto>> IntervenantFindAll(){

        return new ResponseEntity<>(intervenantServiceInterface.intervenantList(), HttpStatus.OK);
    }
}
