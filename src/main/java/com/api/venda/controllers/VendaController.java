package com.api.venda.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.venda.services.VendaService;

import com.api.venda.models.Venda;
import com.api.venda.models.VendaRequest;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    // Endpoint para criar uma venda
    @PostMapping
    public Venda createVenda(@RequestBody VendaRequest vendaRequest) {
        try {
            // Passe os dados da requisição para o serviço de vendas
            return vendaService.createVenda(vendaRequest.getUserId(), vendaRequest.getProdutoId(), vendaRequest.getQuantity());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar venda: " + e.getMessage());
        }
    }
}
