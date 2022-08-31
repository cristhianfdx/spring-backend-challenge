package com.backend.challenge.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.challenge.domain.models.Debt;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Long> {

    @Query(value = "SELECT * FROM debts d JOIN banks b ON d.bank_code=b.code JOIN users u ON b.user_id=u.id", nativeQuery = true)
    List<Debt> findAllByDocumentNumber(String documentNumber);

}
