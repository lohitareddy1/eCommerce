package com.project.ecommerce.repositories;

import com.project.ecommerce.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, String> {

    @Override
    Optional<Product> findById(String s);

    @Override
    void delete(Product delete);
}