package com.djamel.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djamel.entities.Employe;
import com.djamel.entities.Service;

@Repository
public interface RepoService extends JpaRepository<Service, Integer>{

	Optional<Service> findByName(String Name);
	Optional<Service> findByPort(String Port);

}
