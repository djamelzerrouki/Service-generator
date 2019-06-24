package com.djamel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djamel.entities.Employe;

@Repository
public interface RepoEmploye extends JpaRepository<Employe, Integer>{

	Optional<Employe> findByName(String Name);
 
}
