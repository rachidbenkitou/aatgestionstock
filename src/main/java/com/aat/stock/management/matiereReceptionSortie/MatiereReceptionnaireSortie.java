package com.aat.stock.management.matiereReceptionSortie;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatiereReceptionnaireSortie {

    @EmbeddedId
    private MatiereReceptionnaireId matiereReceptionnaireId;

    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("matiereId")
    @JoinColumn(name = "id_matiere_premiere")
    MatierePremiere matierePremiere;


    @ManyToOne(fetch=FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @MapsId("receptionnaireId")
    @JoinColumn(name = "id_fournisseur")
    Receptionnaire receptionnaire;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateDemande;

    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date lastUpdated;

    private boolean isUrgence;

    private short  quantite;

    private boolean isConfirmed;

}
