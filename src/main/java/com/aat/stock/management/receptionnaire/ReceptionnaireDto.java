package com.aat.stock.management.receptionnaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReceptionnaireDto {
    private String prenom;
    private String nom;
    private String telephone;
    private String email;

    /*
    @JsonIgnore
    private List<MatiereReceptionnaireSortie> matiereReceptionnaireSorties;
     */


}
