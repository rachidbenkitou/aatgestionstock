package com.aat.stock.management.fournisseur;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FournisseurDto {
    private String nom;
    private String telephone;

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
}
