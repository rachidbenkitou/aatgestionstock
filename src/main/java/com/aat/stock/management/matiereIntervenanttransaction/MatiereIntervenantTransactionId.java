package com.aat.stock.management.matiereIntervenanttransaction;

import javax.persistence.Embeddable;
import java.io.Serializable;



@Embeddable
public class MatiereIntervenantTransactionId implements Serializable {

    private Long intervenantId;
    private String matiereId;

    public MatiereIntervenantTransactionId(Long intervenantId, String matiereId) {
        this.intervenantId = intervenantId;
        this.matiereId = matiereId;
    }

    public MatiereIntervenantTransactionId() {
    }

    public Long getIntervenantId() {
        return intervenantId;
    }

    public void setIntervenantId(Long intervenantId) {
        this.intervenantId = intervenantId;
    }

    public String getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(String matiereId) {
        this.matiereId = matiereId;
    }
}
