package com.aat.stock.management.matierePremiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatierePremiereRepository extends JpaRepository<MatierePremiere, String> {
    @Query("select m from MatierePremiere m where m.code like :kw")
    public List<MatierePremiere> findMatierePremiereByCode(@Param("kw") String keyword);
    @Query("select m from MatierePremiere m where m.designation like :kw")
    public List<MatierePremiere> findMatierePremiereByDesign(@Param("kw") String keyword);
    MatierePremiere findMatierePremiereByDesignation(String designation);
    @Query("select m from MatierePremiere m where m.code=?1")
    MatierePremiere findBycodeMatierePremiere(String code);


}
