package com.aat.stock.management.transaction.receptionnaireMatiere;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ReceptionnaireMatiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransactionSortie;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_receptionnaire")
    Receptionnaire receptionnaire;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateTransaction;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;
    private short quantiteLivre;
    private boolean isConfirmed;
    private String unite;
    //private String lieuAffectation;
    //private double puHt;
    private String receptionnaireCne;
    private String articleCode;
    private String articleDesignation;

    public ReceptionnaireMatiere() {
    }

    public ReceptionnaireMatiere(Long idTransactionSortie, MatierePremiere matierePremiere, Receptionnaire receptionnaire, Date dateTransaction, Date lastModified, short quantiteLivre, boolean isConfirmed, String unite, String receptionnaireCne, String articleCode, String articleDesignation) {
        this.idTransactionSortie = idTransactionSortie;
        this.matierePremiere = matierePremiere;
        this.receptionnaire = receptionnaire;
        this.dateTransaction = dateTransaction;
        this.lastModified = lastModified;
        this.quantiteLivre = quantiteLivre;
        this.isConfirmed = isConfirmed;
        this.unite = unite;
        this.receptionnaireCne = receptionnaireCne;
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
        return receptionnaireCne;
    }

    public void setReceptionnaireCne(String receptionnaireCne) {
        this.receptionnaireCne = receptionnaireCne;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

}