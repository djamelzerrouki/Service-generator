package com.djamel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.djamel.entities.Role;

@Repository
public interface RepoRole extends JpaRepository<Role, Integer>{

}
