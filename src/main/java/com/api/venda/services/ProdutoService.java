package com.api.venda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.venda.models.Produto;
import com.api.venda.repositories.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto findById(Long id) {
        return this.produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Usuário não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
    }

    @Transactional
    public Produto create(Produto obj) {
        obj.setId(null);
        return this.produtoRepository.save(obj);
    }

    @Transactional
    public Produto update(Produto obj) {
        Produto existingProduto = findById(obj.getId());
        updateData(existingProduto, obj);
        return this.produtoRepository.save(existingProduto);
    }

    private void updateData(Produto existingProduto, Produto obj) {
        existingProduto.setName(obj.getName());
        existingProduto.setQuantidade(obj.getQuantidade());
        existingProduto.setPreco(obj.getPreco());
    }

    @Transactional
    public void delete(Long id) {
        findById(id); // Verifica se o usuário existe
        try {
            this.produtoRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!", e);
        }
    }
}
