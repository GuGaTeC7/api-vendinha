package com.api.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.venda.models.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long> {

}
