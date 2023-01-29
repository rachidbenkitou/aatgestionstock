package com.aat.stock.management.matiereFournisseurEntree;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatiereFournisseurEntree {

    @EmbeddedId
    private MatiereFournisseurId matiereFournisseurId;

    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("matiereId")
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;


    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("fournisseurId")
    @JoinColumn(name = "id_fournisseur")
    Fournisseur fournisseur;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateReception;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;

    private String lieuAffectation;

    private short quantiteLivre;

    private float puHt;

    private boolean isConfirmed;

}
