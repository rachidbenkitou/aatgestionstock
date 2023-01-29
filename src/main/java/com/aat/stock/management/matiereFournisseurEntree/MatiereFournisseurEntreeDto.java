package com.aat.stock.management.matiereFournisseurEntree;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class MatiereFournisseurEntreeDto {

    MatierePremiere matierePremiere;
    Fournisseur fournisseur;
    private Date dateReception;

    private Date lastModified;

    private String lieuAffectation;

    private short quantiteLivre;

    private float puHt;

    private boolean isConfirmed;

}
