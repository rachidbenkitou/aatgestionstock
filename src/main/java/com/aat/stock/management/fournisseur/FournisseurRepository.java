package com.aat.stock.management.fournisseur;

import com.aat.stock.management.filiere.Filiere;
import com.aat.stock.management.receptionnaire.Receptionnaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface FournisseurRepository extends JpaRepository< Fournisseur,Long> {
    @Query("select f from Fournisseur f where f.ice like :kw")
    List<Fournisseur> findByICE(@Param("kw") String ice);
    Fournisseur findByIce(String ice);
    @Transactional
    void deleteFournisseurByIce(String ice);
}
