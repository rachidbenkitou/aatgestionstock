package com.aat.stock.management.transaction.fournisseurMatiere;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.transaction.fournisseurMatiere.fournisseurMatiereId.FournisseurMatiereId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class FournisseurMatiere  implements Serializable{
    @EmbeddedId
    private FournisseurMatiereId fournisseurMatiereId;
    @ManyToOne(fetch= FetchType.LAZY,  cascade = CascadeType.PERSIST)
    @MapsId("matiereId")
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @MapsId("fournisseurId")
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
    //@JsonIgnore
    private String articleDesignation;
    public FournisseurMatiere(FournisseurMatiereId fournisseurMatiereId, MatierePremiere matierePremiere, Fournisseur fournisseur, boolean isUrgence, Date dateTransaction, Date lastModified, short quantiteLivre, boolean isConfirmed, String unite) {
        this.fournisseurMatiereId = fournisseurMatiereId;
        this.matierePremiere = matierePremiere;
        this.fournisseur = fournisseur;
        this.isUrgence = isUrgence;
        this.dateTransaction = dateTransaction;
        this.lastModified = lastModified;
        this.quantiteLivre = quantiteLivre;
        this.isConfirmed = isConfirmed;
        this.unite = unite;
    }

    public FournisseurMatiere() {
    }

    public String getFournisseurIce() {
        return fournisseurIce;
    }

    public void setFournisseurIce(String fournisseurIce) {
        this.fournisseurIce = fournisseurIce;
    }

    public String getArticleDesignation() {
        return articleDesignation;
    }

    public void setArticleDesignation(String articleDesignation) {
        this.articleDesignation = articleDesignation;
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

    public boolean isUrgence() {
        return isUrgence;
    }

    public void setUrgence(boolean urgence) {
        isUrgence = urgence;
    }
}
