package com.api.venda.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    private Integer quantidade;

    @Column(name = "preco", nullable = false)
    private Double preco;

}