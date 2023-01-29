package com.aat.stock.management.matiereReceptionSortie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereReceptionSortieRepository extends JpaRepository<MatiereReceptionnaireSortie,MatiereReceptionnaireId> {
}
