package com.aat.stock.management.filiere;


import com.aat.stock.management.matierePremiere.MatierePremiere;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Filiere implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Short id;

    @Column(unique = true)
    private String nom;

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
