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
@Getter
@Setter
public class Receptionnaire extends Intervenant {
    private String prenom;

    /*
    @OneToMany(mappedBy = "receptionnaire")
    private List<MatiereReceptionnaireSortie> matiereReceptionnaireSorties;
     */


}
