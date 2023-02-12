package com.aat.stock.management.fournisseur;


import com.aat.stock.management.intervenant.IntervenantDto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public class FournisseurDto extends IntervenantDto {
    private Long id;
    private String nom;
    private String telephone;
    private String email;
    private String ice;

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

    public String getIce() {
        return ice;
    }

    public void setIce(String ice) {
        this.ice = ice;
    }
}
