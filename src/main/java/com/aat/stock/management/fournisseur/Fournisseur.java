package com.aat.stock.management.fournisseur;

import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("fournisseur")
@AllArgsConstructor
@NoArgsConstructor
public class Fournisseur extends Intervenant implements Serializable {
    private String ice;
    public String getIce() {
        return ice;
    }
    public void setIce(String ice) {
        this.ice = ice;
    }
}
