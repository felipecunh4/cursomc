package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
}
