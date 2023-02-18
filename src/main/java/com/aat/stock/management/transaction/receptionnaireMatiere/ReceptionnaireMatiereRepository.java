package com.aat.stock.management.transaction.receptionnaireMatiere;

import com.aat.stock.management.transaction.fournisseurMatiere.FournisseurMatiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReceptionnaireMatiereRepository extends JpaRepository<ReceptionnaireMatiere, Long> {
    //@Transactional
    //void deleteAllByReceptionnaireCne(String cne);
    //List<ReceptionnaireMatiere> findAllByReceptionnaireCne(String cne);
    @Query("select rm from ReceptionnaireMatiere rm where rm.receptionnaire.cne like :kw")
    public List<ReceptionnaireMatiere> findAllByReceptionnaireCne(@Param("kw") String cne);
    public ReceptionnaireMatiere findByIdTransactionSortie(Long idTransactionSortie);
}
