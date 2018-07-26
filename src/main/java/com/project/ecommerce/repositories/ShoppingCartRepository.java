package com.project.ecommerce.repositories;

import com.project.ecommerce.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, String> {

@Override
Optional<ShoppingCart> findById(String s);

@Override
    void delete(ShoppingCart delete);
}