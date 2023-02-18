package com.aat.stock.management.transaction.fournisseurMatiere;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class FournisseurMatiere  implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idTransactionEntree;
    @ManyToOne(fetch= FetchType.LAZY,  cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_fournisseur")
    Fournisseur fournisseur;
    private boolean isUrgence;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateTransaction;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;
    private short quantiteLivre;
    private boolean isConfirmed;
    private String unite;
    private String fournisseurIce;
    private String lieuAffectation;
    private double puHt;
    //@JsonIgnore
    private String articleCode;
    private String articleDesignation;

    public FournisseurMatiere(Long idTransactionEntree, MatierePremiere matierePremiere, Fournisseur fournisseur, boolean isUrgence, Date dateTransaction, Date lastModified, short quantiteLivre, boolean isConfirmed, String unite, String fournisseurIce, String lieuAffectation, double puHt, String articleCode, String articleDesignation) {
        this.idTransactionEntree = idTransactionEntree;
        this.matierePremiere = matierePremiere;
        this.fournisseur = fournisseur;
        this.isUrgence = isUrgence;
        this.dateTransaction = dateTransaction;
        this.lastModified = lastModified;
        this.quantiteLivre = quantiteLivre;
        this.isConfirmed = isConfirmed;
        this.unite = unite;
        this.fournisseurIce = fournisseurIce;
        this.lieuAffectation = lieuAffectation;
        this.puHt = puHt;
        this.articleCode = articleCode;
        this.articleDesignation = articleDesignation;
    }

    public FournisseurMatiere() {
    }

    public String getArticleDesignation() {
        return articleDesignation;
    }

    public void setArticleDesignation(String articleDesignation) {
        this.articleDesignation = articleDesignation;
    }

    public String getFournisseurIce() {
        return fournisseurIce;
    }

    public void setFournisseurIce(String fournisseurIce) {
        this.fournisseurIce = fournisseurIce;
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

    public String getLieuAffectation() {
        return lieuAffectation;
    }

    public void setLieuAffectation(String lieuAffectation) {
        this.lieuAffectation = lieuAffectation;
    }

    public double getPuHt() {
        return puHt;
    }

    public void setPuHt(double puHt) {
        this.puHt = puHt;
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

    public Long getIdTransactionEntree() {
        return idTransactionEntree;
    }

    public void setIdTransactionEntree(Long idTransactionEntree) {
        this.idTransactionEntree = idTransactionEntree;
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

    public boolean isUrgence() {
        return isUrgence;
    }

    public void setUrgence(boolean urgence) {
        isUrgence = urgence;
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode;
    }

}
