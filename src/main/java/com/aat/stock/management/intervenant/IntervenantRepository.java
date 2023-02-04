package com.aat.stock.management.intervenant;

import com.aat.stock.management.fournisseur.Fournisseur;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IntervenantRepository extends JpaRepository<Intervenant,Long> {
    Fournisseur findByIce(String ice);
    Receptionnaire findByCne(String cne);
}
