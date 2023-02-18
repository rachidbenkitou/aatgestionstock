package com.aat.stock.management.receptionnaire;

import com.aat.stock.management.intervenant.Intervenant;
import com.aat.stock.management.transaction.receptionnaireMatiere.ReceptionnaireMatiere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@DiscriminatorValue("receptionnaire")
@AllArgsConstructor
@NoArgsConstructor
public class Receptionnaire extends Intervenant implements Serializable {
    private String prenom;
    @Column(unique = true)
    private String cne;
    @JsonIgnore
    @OneToMany(mappedBy = "receptionnaire",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ReceptionnaireMatiere> receptionnaireMatieres;
/*
    @OneToMany(mappedBy = "receptionnaire")
    private List<MatiereReceptionnaireSortie> matiereReceptionnaireSorties;
     */

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public List<ReceptionnaireMatiere> getReceptionnaireMatieres() {
        return receptionnaireMatieres;
    }

    public void setReceptionnaireMatieres(List<ReceptionnaireMatiere> receptionnaireMatieres) {
        this.receptionnaireMatieres = receptionnaireMatieres;
    }
}
