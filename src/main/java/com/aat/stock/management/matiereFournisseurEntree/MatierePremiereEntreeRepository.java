package com.aat.stock.management.matiereFournisseurEntree;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatierePremiereEntreeRepository extends JpaRepository<MatiereFournisseurEntree, MatiereFournisseurId> {
}
