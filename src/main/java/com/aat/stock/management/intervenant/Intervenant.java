package com.aat.stock.management.intervenant;


import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 14)
@AllArgsConstructor
@NoArgsConstructor
public abstract class Intervenant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    //private String prenom;
    private String telephone;
    private String email;
    @OneToMany(mappedBy = "intervenant")
    List<MatiereIntervenantTransaction> matiereIntervenantTransactions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    /*
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

     */

    public List<MatiereIntervenantTransaction> getMatiereIntervenantTransactions() {
        return matiereIntervenantTransactions;
    }

    public void setMatiereIntervenantTransactions(List<MatiereIntervenantTransaction> matiereIntervenantTransactions) {
        this.matiereIntervenantTransactions = matiereIntervenantTransactions;
    }
}
