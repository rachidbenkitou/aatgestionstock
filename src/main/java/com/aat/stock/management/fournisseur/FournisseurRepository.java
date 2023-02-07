package com.aat.stock.management.fournisseur;

import com.aat.stock.management.receptionnaire.Receptionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository< Fournisseur,Long> {
    Fournisseur findByIce(String ice);
    void deleteByIce(String ice);
}
