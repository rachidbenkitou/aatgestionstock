package com.aat.stock.management.matiereIntervenanttransaction;

import com.aat.stock.management.matiereIntervenanttransaction.service.MatiereIntervenantTransactionServiceIntr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin("*")
public class MatiereIntervenantTransactionController {
    @Autowired
    private MatiereIntervenantTransactionServiceIntr matiereIntervenantTransactionServiceIntr;

    @PostMapping("/save")
    public MatiereIntervenantTransactionDTO saveTransaction(@RequestBody MatiereIntervenantTransactionDTO matiereIntervenantTransactionDTO){

        return matiereIntervenantTransactionServiceIntr.saveMatiereIntervenantTransactionDTO(matiereIntervenantTransactionDTO);
    }


    @GetMapping("/all")
    public List<MatiereIntervenantTransactionDTO> findAllTransaction(){
        return matiereIntervenantTransactionServiceIntr.listMatiereIntervenantTransactionDTO();
    }

}
