package com.project.ecommerce.repositories;

import com.project.ecommerce.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public  interface UserRepository extends CrudRepository<User, String> {

    @Override
    Optional<User> findById(String s);

    @Override
    void delete(User delete);
}