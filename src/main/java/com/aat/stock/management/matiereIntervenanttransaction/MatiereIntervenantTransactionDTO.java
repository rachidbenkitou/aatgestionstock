package com.aat.stock.management.matiereIntervenanttransaction;

import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MatiereIntervenantTransactionDTO {
    MatierePremiere matierePremiere;
    Intervenant intervenant;
    private Date dateTransaction;
    private Date lastModified;

    private String lieuAffectation;

    private short quantiteLivre;

    private float puHt;

    private boolean isConfirmed;

    private boolean isUrgence;

}
