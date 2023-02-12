package com.aat.stock.management.filiere;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class FiliereDto {

    private Short id ;
    private String nom;

    @JsonIgnore
    private List<MatierePremiere> matierePremieres;

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<MatierePremiere> getMatierePremieres() {
        return matierePremieres;
    }

    public void setMatierePremieres(List<MatierePremiere> matierePremieres) {
        this.matierePremieres = matierePremieres;
    }
}
