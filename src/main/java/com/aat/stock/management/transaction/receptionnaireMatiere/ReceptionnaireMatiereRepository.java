package com.aat.stock.management.transaction.receptionnaireMatiere;

import com.aat.stock.management.transaction.receptionnaireMatiere.receptionnaireMatiereId.ReceptionnaireMatiereId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ReceptionnaireMatiereRepository extends JpaRepository<ReceptionnaireMatiere, ReceptionnaireMatiereId> {
    @Transactional
    void deleteAllByReceptionnaireCne(String cne);
    List<ReceptionnaireMatiere> findAllByReceptionnaireCne(String cne);
}
