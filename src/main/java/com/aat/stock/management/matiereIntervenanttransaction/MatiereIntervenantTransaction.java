package com.aat.stock.management.matiereIntervenanttransaction;

import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class MatiereIntervenantTransaction implements Serializable {
    @EmbeddedId
    private MatiereIntervenantTransactionId matiereIntervenantTransactionId;

    /*
    @ManyToOne(fetch= FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("matiereId")
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;


    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("intervenantId")
    @JoinColumn(name = "id_intervenant")
    Intervenant intervenant;

 */

    @ManyToOne(fetch= FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("matiereId")
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;


    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("intervenantId")
    @JoinColumn(name = "id_intervenant")
    Intervenant intervenant;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateTransaction;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastModified;

    private String lieuAffectation;

    private short quantiteLivre;

    private float puHt;

    private boolean isConfirmed;

    private boolean isUrgence;

    //This will denote that the attribute need not be persisted in the DB and JPA won't attempt to create a column in the table.
    @Transient
    private String intervenantIce;
    @Transient
    private String intervenantCne;
    @Transient
    private String articleDesignation;

    public MatiereIntervenantTransactionId getMatiereIntervenantTransactionId() {
        return matiereIntervenantTransactionId;
    }

    public void setMatiereIntervenantTransactionId(MatiereIntervenantTransactionId matiereIntervenantTransactionId) {
        this.matiereIntervenantTransactionId = matiereIntervenantTransactionId;
    }

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

    public String getIntervenantIce() {
        return intervenantIce;
    }

    public void setIntervenantIce(String intervenantIce) {
        this.intervenantIce = intervenantIce;
    }

    public String getIntervenantCne() {
        return intervenantCne;
    }

    public void setIntervenantCne(String intervenantCne) {
        this.intervenantCne = intervenantCne;
    }

    public String getArticleDesignation() {
        return articleDesignation;
    }

    public void setArticleDesignation(String articleDesignation) {
        this.articleDesignation = articleDesignation;
    }
}
