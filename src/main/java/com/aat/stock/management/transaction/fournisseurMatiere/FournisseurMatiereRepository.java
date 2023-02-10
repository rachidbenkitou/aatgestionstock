package com.aat.stock.management.transaction.fournisseurMatiere;

import com.aat.stock.management.transaction.fournisseurMatiere.fournisseurMatiereId.FournisseurMatiereId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FournisseurMatiereRepository extends JpaRepository<FournisseurMatiere, FournisseurMatiereId> {
    @Transactional
    void deleteAllByFournisseurIce(String ice);
    List<FournisseurMatiere> findAllByFournisseurIce(String ice);
}
