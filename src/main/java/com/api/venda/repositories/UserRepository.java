package com.api.venda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.venda.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
