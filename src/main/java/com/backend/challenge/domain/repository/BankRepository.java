package com.backend.challenge.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.challenge.domain.models.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String> {

    List<Bank> findAllByUserId(Long userId);

}
