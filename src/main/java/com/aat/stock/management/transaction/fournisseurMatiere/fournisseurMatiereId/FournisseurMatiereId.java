package com.aat.stock.management.transaction.fournisseurMatiere.fournisseurMatiereId;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class FournisseurMatiereId implements Serializable {
    private Long fournisseurId;
    private String matiereId;


    public FournisseurMatiereId(Long fournisseurId, String matiereId) {
        this.fournisseurId = fournisseurId;
        this.matiereId = matiereId;
    }

    public FournisseurMatiereId() {
    }

    public Long getFournisseurId() {
        return fournisseurId;
    }

    public void setFournisseurId(Long fournisseurId) {
        this.fournisseurId = fournisseurId;
    }

    public String getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(String matiereId) {
        this.matiereId = matiereId;
    }
}
