package com.aat.stock.management.receptionnaire;

import com.aat.stock.management.intervenant.Intervenant;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("receptionnaire")
@AllArgsConstructor
@NoArgsConstructor
public class Receptionnaire extends Intervenant implements Serializable {
    private String prenom;
    @Column(unique = true)
    private String cne;

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
}
