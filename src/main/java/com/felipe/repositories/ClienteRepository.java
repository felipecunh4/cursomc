package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
