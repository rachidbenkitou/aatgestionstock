
package com.aat.stock.management.intervenant;

import com.aat.stock.management.matiereIntervenanttransaction.MatiereIntervenantTransaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class IntervenantDto {
    private Long id;
    private String type;

    @JsonIgnore
    List<MatiereIntervenantTransaction> matiereIntervenantTransactions;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<MatiereIntervenantTransaction> getMatiereIntervenantTransactions() {
        return matiereIntervenantTransactions;
    }

    public void setMatiereIntervenantTransactions(List<MatiereIntervenantTransaction> matiereIntervenantTransactions) {
        this.matiereIntervenantTransactions = matiereIntervenantTransactions;
    }
}

