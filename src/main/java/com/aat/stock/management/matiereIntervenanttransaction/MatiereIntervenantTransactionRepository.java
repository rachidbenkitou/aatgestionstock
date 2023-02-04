package com.aat.stock.management.matiereIntervenanttransaction;

import com.aat.stock.management.matierePremiere.MatierePremiereDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatiereIntervenantTransactionRepository extends JpaRepository<MatiereIntervenantTransaction, MatiereIntervenantTransactionId> {

}
