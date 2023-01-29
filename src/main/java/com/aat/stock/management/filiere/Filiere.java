package com.aat.stock.management.filiere;


import com.aat.stock.management.matierePremiere.MatierePremiere;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Filiere {
    @Id
    private String nom;

    private String filierePrefix;

    @ManyToMany
    @JoinTable(
            name="filiere_matiere",
            joinColumns=@JoinColumn(name="filiere_nom"),
            inverseJoinColumns=@JoinColumn(name="matiere_id")
    )
    List<MatierePremiere> matierePremieres;

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private byte id; //byte: from -128 to 127
     */

    /*
    @OneToMany(mappedBy = "filiere")
    private List<MatierePremiere> matierePremieres;
     */

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
