package com.api.venda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import com.api.venda.repositories.ProdutoRepository;
import com.api.venda.repositories.UserRepository;
import com.api.venda.repositories.VendaRepository;
import com.api.venda.models.Venda;
import com.api.venda.models.Produto;
import com.api.venda.models.User;

@Service
public class VendaService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private UserRepository userRepository;  // Adicionar o UserRepository para carregar o usuário

    // Método para buscar todas as vendas
    public List<Venda> getAllVendas() {
        return vendaRepository.findAll();
    }

    // Método para buscar uma venda específica por ID
    public Venda getVendaById(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada"));
    }
    @Transactional
    public Venda createVenda(Long userId, Long produtoId, int quantity) throws Exception {
        // Verifica se o produto existe
        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new Exception("Venda não encontrada"));
        
        // Verifica se há estoque suficiente
        if (produto.getQuantidade() < quantity) {
            throw new Exception("Quantidade insuficiente em estoque");
        }

        // Carrega o usuário
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("Usuário não encontrado"));

        // Cria a venda
        Venda venda = new Venda();
        venda.setUser(user);  // Agora o usuário existente é atribuído corretamente
        venda.setProduto(produto);
        venda.setQuantity(quantity);
        venda.setPrice(produto.getPreco() * quantity);

        // Atualiza o estoque
        produto.setQuantidade(produto.getQuantidade() - quantity);
        produtoRepository.save(produto);

        // Salva a venda
        return vendaRepository.save(venda);
    }

    @Transactional
    public void delete(Long id) {
        getVendaById(id); 
        try {
            this.vendaRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!", e);
        }
    }
}
