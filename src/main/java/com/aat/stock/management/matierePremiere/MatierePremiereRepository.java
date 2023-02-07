package com.aat.stock.management.matierePremiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatierePremiereRepository extends JpaRepository<MatierePremiere, String> {
    MatierePremiere findMatierePremiereByDesignation(String designation);
}
