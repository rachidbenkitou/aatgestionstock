package com.aat.stock.management.transaction.receptionnaireMatiere;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import com.aat.stock.management.transaction.receptionnaireMatiere.receptionnaireMatiereId.ReceptionnaireMatiereId;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ReceptionnaireMatiere implements Serializable {
    @EmbeddedId
    private ReceptionnaireMatiereId receptionnaireMatiereId;

    @ManyToOne(fetch= FetchType.LAZY,  cascade = CascadeType.PERSIST)
    @MapsId("matiereId")
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;
    @ManyToOne(fetch=FetchType.LAZY,cascade = CascadeType.PERSIST)
    @MapsId("receptionnaireId")
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
    private String lieuAffectation;
    private double puHt;
    private String receptionnaireCne;
    private String articleDesignation;

    public ReceptionnaireMatiere() {
    }

    public ReceptionnaireMatiere(ReceptionnaireMatiereId receptionnaireMatiereId, MatierePremiere matierePremiere, Receptionnaire receptionnaire, Date dateTransaction, Date lastModified, short quantiteLivre, boolean isConfirmed, String unite, String lieuAffectation, double puHt, String receptionnaireCne, String articleDesignation) {
        this.receptionnaireMatiereId = receptionnaireMatiereId;
        this.matierePremiere = matierePremiere;
        this.receptionnaire = receptionnaire;
        this.dateTransaction = dateTransaction;
        this.lastModified = lastModified;
        this.quantiteLivre = quantiteLivre;
        this.isConfirmed = isConfirmed;
        this.unite = unite;
        this.lieuAffectation = lieuAffectation;
        this.puHt = puHt;
        this.receptionnaireCne = receptionnaireCne;
        this.articleDesignation = articleDesignation;
    }

    public ReceptionnaireMatiereId getReceptionnaireMatiereId() {
        return receptionnaireMatiereId;
    }

    public void setReceptionnaireMatiereId(ReceptionnaireMatiereId receptionnaireMatiereId) {
        this.receptionnaireMatiereId = receptionnaireMatiereId;
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

    public String getReceptionnaireCne() {
        return receptionnaireCne;
    }

    public void setReceptionnaireCne(String receptionnaireCne) {
        this.receptionnaireCne = receptionnaireCne;
    }

    public String getArticleDesignation() {
        return articleDesignation;
    }

    public void setArticleDesignation(String articleDesignation) {
        this.articleDesignation = articleDesignation;
    }
}
