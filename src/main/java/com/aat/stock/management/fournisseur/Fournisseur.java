package com.aat.stock.management.fournisseur;

import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import com.aat.stock.management.transaction.fournisseurMatiere.FournisseurMatiere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("fournisseur")
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur extends Intervenant implements Serializable {
    @Column(unique = true)
    private String ice;
    @JsonIgnore
    @OneToMany(mappedBy = "fournisseur",fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    List<FournisseurMatiere> fournisseurMatieres;
    public String getIce() {
        return ice;
    }
    public void setIce(String ice) {
        this.ice = ice;
    }
}
