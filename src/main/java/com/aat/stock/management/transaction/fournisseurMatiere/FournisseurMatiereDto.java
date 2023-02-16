package com.aat.stock.management.transaction.fournisseurMatiere;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.transaction.fournisseurMatiere.fournisseurMatiereId.FournisseurMatiereId;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
public class FournisseurMatiereDto  {
    private FournisseurMatiereId fournisseurMatiereId;
    @JsonIgnore
    MatierePremiere matierePremiere;
    @JsonIgnore
    Fournisseur fournisseur;
    private Date dateTransaction;
    private Date lastModified;
    private short quantiteLivre;
    private boolean isConfirmed;
    private String unite;
    private boolean isUrgence;
    //@JsonIgnore
    private String fournisseurIce;
    //@JsonIgnore
    private String articleCode;
    private String articleDesignation;

    public FournisseurMatiereDto() {
    }

    public FournisseurMatiereDto(FournisseurMatiereId fournisseurMatiereId, MatierePremiere matierePremiere, Fournisseur fournisseur, Date dateTransaction, Date lastModified, short quantiteLivre, boolean isConfirmed, String unite, boolean isUrgence, String fournisseurIce,String articleCode, String articleDesignation) {
        this.fournisseurMatiereId = fournisseurMatiereId;
        this.matierePremiere = matierePremiere;
        this.fournisseur = fournisseur;
        this.dateTransaction = dateTransaction;
        this.lastModified = lastModified;
        this.quantiteLivre = quantiteLivre;
        this.isConfirmed = isConfirmed;
        this.unite = unite;
        this.isUrgence = isUrgence;
        this.fournisseurIce = fournisseurIce;
        this.articleCode= articleCode;
        this.articleDesignation= articleDesignation;
    }

    public String getFournisseurIce() {
        return fournisseurIce;
    }

    public void setFournisseurIce(String fournisseurIce) {
        this.fournisseurIce = fournisseurIce;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public FournisseurMatiereId getFournisseurMatiereId() {
        return fournisseurMatiereId;
    }

    public void setFournisseurMatiereId(FournisseurMatiereId fournisseurMatiereId) {
        this.fournisseurMatiereId = fournisseurMatiereId;
    }

    public MatierePremiere getMatierePremiere() {
        return matierePremiere;
    }

    public void setMatierePremiere(MatierePremiere matierePremiere) {
        this.matierePremiere = matierePremiere;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
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

    public short getQuantiteLivre() {
        return quantiteLivre;
    }

    public void setQuantiteLivre(short quantiteLivre) {
        this.quantiteLivre = quantiteLivre;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public boolean isUrgence() {
        return isUrgence;
    }

    public void setUrgence(boolean urgence) {
        isUrgence = urgence;
    }

    public String getArticleDesignation() {
        return articleDesignation;
    }

    public void setArticleDesignation(String articleDesignation) {
        this.articleDesignation = articleDesignation;
    }
}
