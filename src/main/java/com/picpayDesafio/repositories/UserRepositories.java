package com.picpayDesafio.repositories;

import com.picpayDesafio.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositories extends JpaRepository<User, Long> {

    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(Long id);

}
