package com.aat.stock.management.receptionnaire;

import com.aat.stock.management.intervenant.IntervenantDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ReceptionnaireDto extends IntervenantDto {
    private Long id;
    private String prenom;
    private String nom;
    private String telephone;
    private String email;
    private String cne;

/*
    @JsonIgnore
    private List<MatiereReceptionnaireSortie> matiereReceptionnaireSorties;
     */

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

}
