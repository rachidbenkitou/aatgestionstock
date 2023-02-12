package com.aat.stock.management.filiere;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FiliereRepository extends JpaRepository<Filiere, Short> {
    @Query("select f from Filiere f where f.nom like :kw")
    public List<Filiere> searchFiliere(@Param("kw") String keyword);
}
