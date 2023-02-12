package com.aat.stock.management.filiere;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FiliereDto {
    private String nom;
    private Short id;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Short getId() {
        return id;
    }
    public void setId(Short id) {
        this.id = id;
    }
}
