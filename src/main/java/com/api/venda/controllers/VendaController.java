package com.api.venda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.api.venda.services.VendaService;

import com.api.venda.models.Venda;
import com.api.venda.models.VendaRequest;

@RestController
@CrossOrigin("*")
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;


    // Endpoint para buscar todas as vendas
    @GetMapping
    public ResponseEntity<List<Venda>> getAllVendas() {
        List<Venda> vendas = vendaService.getAllVendas();
        return new ResponseEntity<>(vendas, HttpStatus.OK);
    }

    // Endpoint para buscar uma venda específica por ID
    @GetMapping("/{id}")
    public ResponseEntity<Venda> getVendaById(@PathVariable Long id) {
        try {
            Venda venda = vendaService.getVendaById(id);
            return new ResponseEntity<>(venda, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
