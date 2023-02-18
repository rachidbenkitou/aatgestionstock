package com.aat.stock.management.transaction.receptionnaireMatiere;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

public class ReceptionnaireMatiereDto {
    private Long idTransactionSortie;
    @JsonIgnore
    MatierePremiere matierePremiere;
    @JsonIgnore
    Receptionnaire receptionnaire;
    private Date dateTransaction;
    private Date lastModified;
    private short quantiteLivre;
    private boolean isConfirmed;
    private String unite;
    private String receptionnairecCne;
    private String articleCode;
    private String articleDesignation;


    public ReceptionnaireMatiereDto() {
    }

    public ReceptionnaireMatiereDto(Long idTransactionSortie, MatierePremiere matierePremiere, Receptionnaire receptionnaire, Date dateTransaction, Date lastModified, short quantiteLivre, boolean isConfirmed, String unite, String receptionnairecCne, String articleCode, String articleDesignation) {
        this.idTransactionSortie = idTransactionSortie;
        this.matierePremiere = matierePremiere;
        this.receptionnaire = receptionnaire;
        this.dateTransaction = dateTransaction;
        this.lastModified = lastModified;
        this.quantiteLivre = quantiteLivre;
        this.isConfirmed = isConfirmed;
        this.unite = unite;
        this.receptionnairecCne = receptionnairecCne;
        this.articleCode = articleCode;
        this.articleDesignation = articleDesignation;
    }

    public String getArticleDesignation() {
        return articleDesignation;
    }

    public void setArticleDesignation(String articleDesignation) {
        this.articleDesignation = articleDesignation;
    }

    public Long getIdTransactionSortie() {
        return idTransactionSortie;
    }

    public void setIdTransactionSortie(Long idTransactionSortie) {
        this.idTransactionSortie = idTransactionSortie;
    }

    public MatierePremiere getMatierePremiere() {
        return matierePremiere;
    }

    public void setMatierePremiere(MatierePremiere matierePremiere) {
        this.matierePremiere = matierePremiere;
    }

    public Receptionnaire getReceptionnaire() {
        return receptionnaire;
    }

    public void setReceptionnaire(Receptionnaire receptionnaire) {
        this.receptionnaire = receptionnaire;
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

    public String getReceptionnaireCne() {
        return receptionnairecCne;
    }

    public void setReceptionnaireCne(String receptionnaireCne) {
        this.receptionnairecCne = receptionnaireCne;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

    public String getReceptionnairecCne() {
        return receptionnairecCne;
    }

    public void setReceptionnairecCne(String receptionnairecCne) {
        this.receptionnairecCne = receptionnairecCne;
    }

}
