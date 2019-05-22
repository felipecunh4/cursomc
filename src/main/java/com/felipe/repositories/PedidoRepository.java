package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.Pedido;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
}
