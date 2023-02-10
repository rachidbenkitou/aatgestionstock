package com.aat.stock.management.transaction.receptionnaireMatiere.receptionnaireMatiereId;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class ReceptionnaireMatiereId implements Serializable {
    private Long receptionnaireId;
    private String matiereId;

    public ReceptionnaireMatiereId() {
    }

    public ReceptionnaireMatiereId(Long receptionnaireId, String matiereId) {
        this.receptionnaireId = receptionnaireId;
        this.matiereId = matiereId;
    }

    public Long getReceptionnaireId() {
        return receptionnaireId;
    }

    public void setReceptionnaireId(Long receptionnaireId) {
        this.receptionnaireId = receptionnaireId;
    }

    public String getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(String matiereId) {
        this.matiereId = matiereId;
    }
}
