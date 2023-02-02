package com.aat.stock.management.receptionnaire;

import com.aat.stock.management.intervenant.Intervenant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("receptionnaire")
@NoArgsConstructor
@AllArgsConstructor
public class Receptionnaire extends Intervenant {
    private String prenom;

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
