package com.aat.stock.management.matiereIntervenanttransaction;

import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.intervenant.IntervenantDto;
import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MatiereIntervenantTransaction {

    public MatiereIntervenantTransaction(MatiereIntervenantTransactionId matiereIntervenantTransactionId, MatierePremiere matierePremiere, Intervenant intervenant, Date dateTransaction, Date lastModified, String lieuAffectation, short quantiteLivre, float puHt, boolean isConfirmed, boolean isUrgence) {
        this.matiereIntervenantTransactionId = matiereIntervenantTransactionId;
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

    public MatiereIntervenantTransaction() {
    }

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
}
