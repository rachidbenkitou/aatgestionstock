package com.aat.stock.management.matiereReceptionSortie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatiereReceptionnaireId implements Serializable {

    private String matiereId;

    private short receptionnaireId;

}
