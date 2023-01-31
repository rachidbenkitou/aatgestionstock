
package com.aat.stock.management.intervenant;

import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class IntervenantDto {
    private String type;

   /* private String prenom;
    private String nom;
    private String telephone;
    private String email;
    @JsonIgnore
    List<MatiereIntervenantTransaction> matiereIntervenantTransactions;
*/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  /*  public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public List<MatiereIntervenantTransaction> getMatiereIntervenantTransactions() {
        return matiereIntervenantTransactions;
    }

    public void setMatiereIntervenantTransactions(List<MatiereIntervenantTransaction> matiereIntervenantTransactions) {
        this.matiereIntervenantTransactions = matiereIntervenantTransactions;
    }
    */

}

