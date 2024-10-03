package com.api.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.venda.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
