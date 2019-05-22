package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
}
