package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Cidade;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
}
