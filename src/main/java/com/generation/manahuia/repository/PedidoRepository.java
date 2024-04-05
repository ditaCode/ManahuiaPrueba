package com.generation.manahuia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.manahuia.model.Pedido;

@Repository

public interface PedidoRepository extends JpaRepository <Pedido, Long>{
	

}
