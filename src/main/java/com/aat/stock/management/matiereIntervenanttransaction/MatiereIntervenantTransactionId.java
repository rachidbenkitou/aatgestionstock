package com.aat.stock.management.matiereIntervenanttransaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MatiereIntervenantTransactionId implements Serializable {

    private Long intervenantId;
    private String matiereId;
}
