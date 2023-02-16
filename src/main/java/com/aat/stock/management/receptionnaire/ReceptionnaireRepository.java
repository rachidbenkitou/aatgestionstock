package com.aat.stock.management.receptionnaire;

import com.aat.stock.management.fournisseur.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface ReceptionnaireRepository extends JpaRepository<Receptionnaire,Long > {
    @Query("select r from Receptionnaire r where r.cne like :kw")
    List<Receptionnaire> findByCNE(@Param("kw") String cne);
    Receptionnaire findByCne(String cne);
    @Transactional
    void deleteByCne(String cne);
}
