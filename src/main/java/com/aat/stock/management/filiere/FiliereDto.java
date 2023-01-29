package com.aat.stock.management.filiere;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class FiliereDto {

    private String nom;

    private String filierePrefix;

    @JsonIgnore
    private List<MatierePremiere> matierePremieres;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFilierePrefix() {
        return filierePrefix;
    }

    public void setFilierePrefix(String filierePrefix) {
        this.filierePrefix = filierePrefix;
    }

    public List<MatierePremiere> getMatierePremieres() {
        return matierePremieres;
    }

    public void setMatierePremieres(List<MatierePremiere> matierePremieres) {
        this.matierePremieres = matierePremieres;
    }
}
