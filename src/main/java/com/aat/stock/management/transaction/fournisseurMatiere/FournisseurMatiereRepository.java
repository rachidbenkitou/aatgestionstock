package com.aat.stock.management.transaction.fournisseurMatiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FournisseurMatiereRepository extends JpaRepository<FournisseurMatiere, Long> {
    @Transactional
    void deleteAllByFournisseurIce(String ice);
    //List<FournisseurMatiere> findAllByFournisseurIce(String ice);
    @Query("select fm from FournisseurMatiere fm where fm.fournisseur.ice like :kw")
    public List<FournisseurMatiere> findAllByFournisseurIce(@Param("kw") String ice);

    FournisseurMatiere findByIdTransactionEntree(Long id);
}
