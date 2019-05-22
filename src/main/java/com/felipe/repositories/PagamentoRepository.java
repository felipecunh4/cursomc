package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Pagamento;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
	
}
