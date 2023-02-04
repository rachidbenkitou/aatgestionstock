package com.aat.stock.management.matiereIntervenanttransaction;

import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MatiereIntervenantTransactionDTO {
    public MatiereIntervenantTransactionDTO(MatierePremiere matierePremiere, Intervenant intervenant, Date dateTransaction, Date lastModified, String lieuAffectation, short quantiteLivre, float puHt, boolean isConfirmed, boolean isUrgence) {
        this.matierePremiere = matierePremiere;
        this.intervenant = intervenant;
        this.dateTransaction = dateTransaction;
        this.lastModified = lastModified;
        this.lieuAffectation = lieuAffectation;
        this.quantiteLivre = quantiteLivre;
        this.puHt = puHt;
        this.isConfirmed = isConfirmed;
        this.isUrgence = isUrgence;
    }

    public MatiereIntervenantTransactionDTO() {

    }


    MatierePremiere matierePremiere;
    Intervenant intervenant;
    private Date dateTransaction;
    private Date lastModified;

    private String lieuAffectation;

    private short quantiteLivre;

    private float puHt;

    private boolean isConfirmed;

    private boolean isUrgence;

    public MatierePremiere getMatierePremiere() {
        return matierePremiere;
    }

    public void setMatierePremiere(MatierePremiere matierePremiere) {
        this.matierePremiere = matierePremiere;
    }

    public Intervenant getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(Intervenant intervenant) {
        this.intervenant = intervenant;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public String getLieuAffectation() {
        return lieuAffectation;
    }

    public void setLieuAffectation(String lieuAffectation) {
        this.lieuAffectation = lieuAffectation;
    }

    public short getQuantiteLivre() {
        return quantiteLivre;
    }

    public void setQuantiteLivre(short quantiteLivre) {
        this.quantiteLivre = quantiteLivre;
    }

    public float getPuHt() {
        return puHt;
    }

    public void setPuHt(float puHt) {
        this.puHt = puHt;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public boolean isUrgence() {
        return isUrgence;
    }

    public void setUrgence(boolean urgence) {
        isUrgence = urgence;
    }
}
