package com.aat.stock.management.matiereReceptionSortie;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class MatiereReceptionnaireSortieDto {

    MatierePremiere matierePremiere;

    Receptionnaire receptionnaire;

    private Date dateDemande;

    private Date lastUpdated;

    private boolean isUrgence;

    private short  quantite;

    private boolean isConfirmed;

}
