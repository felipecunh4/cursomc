package com.felipe.repositories;

import org.springframework.stereotype.Repository;

import com.felipe.domain.ItemPedido;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {
	
}
