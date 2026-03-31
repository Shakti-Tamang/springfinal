package com.mycompany.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mycompany.myapp.domain.Authority;

/**
 * Spring Data JPA repository for the Authority entity.
 * 
 * is used to tell the compiler/IDE to ignore warnings about unused code.
 */
@SuppressWarnings("unused")
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
