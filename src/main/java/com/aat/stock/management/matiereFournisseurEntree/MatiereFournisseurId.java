package com.aat.stock.management.matiereFournisseurEntree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatiereFournisseurId implements Serializable {
    private short fournisseurId;
    private String matiereId;

}
