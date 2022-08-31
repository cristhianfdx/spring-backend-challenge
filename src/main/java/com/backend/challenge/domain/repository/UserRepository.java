package com.backend.challenge.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.challenge.domain.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByDocumentNumber(String documentNumber);

}
