package com.aat.stock.management.filiere;

import com.aat.stock.management.matierePremiere.MatierePremiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface FiliereRepository extends JpaRepository<Filiere, Short> {
    @Query("select f from Filiere f where f.nom like :kw")
    public List<Filiere> searchFiliere(@Param("kw") String keyword);
    @Query("SELECT f.matierePremieres FROM Filiere f WHERE f.nom = :filiereName")
    List<MatierePremiere> findMatierePremieresByFiliereName(@Param("filiereName") String filiereName);
}
