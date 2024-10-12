package com.api.venda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.venda.repositories.UserRepository;
import com.api.venda.models.User;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(
                        "Usuário não encontrado! Id: " + id + ", Tipo: " + User.class.getName()));
    }

    @Transactional
    public User create(User obj) {
        obj.setId(null);
        return this.userRepository.save(obj);
    }

    @Transactional
    public User update(User obj) {
        User existingUser = findById(obj.getId());
        updateData(existingUser, obj);
        return this.userRepository.save(existingUser);
    }

    private void updateData(User existingUser, User obj) {
        existingUser.setName(obj.getName());
    }

    @Transactional
    public void delete(Long id) {
        findById(id); // Verifica se o usuário existe
        try {
            this.userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Não é possível excluir pois há entidades relacionadas!", e);
        }
    }
}
