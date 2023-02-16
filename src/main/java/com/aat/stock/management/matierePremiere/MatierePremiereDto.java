package com.aat.stock.management.matierePremiere;

import com.aat.stock.management.filiere.Filiere;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MatierePremiereDto {
    private String code;
    private String numeroBrNumeroBs;
    private String designation;
    private short  stockActuel; //short: from -32768 to 32767
    private String unite;
    private short stockInitial;  //short: from -32768 to 32767
    private short totaleEntree;
    private short totaleSortie;
    // @JsonIgnore
    private List<Filiere> filieres;

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }

    public String getNumeroBrNumeroBs() {
        return numeroBrNumeroBs;
    }

    public void setNumeroBrNumeroBs(String numeroBrNumeroBs) {
        this.numeroBrNumeroBs = numeroBrNumeroBs;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public short getStockActuel() {
        return stockActuel;
    }

    public void setStockActuel(short stockActuel) {
        this.stockActuel = stockActuel;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public short getStockInitial() {
        return stockInitial;
    }

    public void setStockInitial(short stockInitial) {
        this.stockInitial = stockInitial;
    }

    public short getTotaleEntree() {
        return totaleEntree;
    }

    public void setTotaleEntree(short totaleEntree) {
        this.totaleEntree = totaleEntree;
    }

    public short getTotaleSortie() {
        return totaleSortie;
    }

    public void setTotaleSortie(short totaleSortie) {
        this.totaleSortie = totaleSortie;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
