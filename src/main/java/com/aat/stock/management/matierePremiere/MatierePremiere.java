package com.aat.stock.management.matierePremiere;

import com.aat.stock.management.filiere.Filiere;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
public class MatierePremiere {
    @Id
    private String code;
    private String numeroBrNumeroBs;
    private String designation;
    private short  stockActuel; //short: from -32768 to 32767
    private String unite;
    private short stockInitial;  //short: from -32768 to 32767

    private short totaleEntree;

    private short totaleSortie;


    @ManyToMany
    @JoinTable(
            name="filiere_matiere",
            joinColumns=@JoinColumn(name="matiere_id"),
            inverseJoinColumns=@JoinColumn(name="filiere_nom")
    )
    private List<Filiere> filieres;


    /*
    @OneToMany(mappedBy = "matierePremiere")
    private List<MatiereReceptionnaireSortie> matiereReceptionnaireSorties;

    @OneToMany(mappedBy = "matierePremiere")
    private List<MatiereFournisseurEntree> matiereFournisseurEntrees;

     */

    /*
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "filiere_id")
    private Filiere filiere;
     */

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public List<Filiere> getFilieres() {
        return filieres;
    }

    public void setFilieres(List<Filiere> filieres) {
        this.filieres = filieres;
    }
}
