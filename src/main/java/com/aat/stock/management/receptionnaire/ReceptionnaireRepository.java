package com.aat.stock.management.receptionnaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionnaireRepository extends JpaRepository<Receptionnaire,Long > {
    Receptionnaire findByCne(String cne);
    void deleteByCne(String cne);
}
