package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Categoria;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
	
}
