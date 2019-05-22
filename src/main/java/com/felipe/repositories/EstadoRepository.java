package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Estado;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
	
}
