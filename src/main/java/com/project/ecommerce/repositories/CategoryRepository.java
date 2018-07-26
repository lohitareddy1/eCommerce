package com.project.ecommerce.repositories;

import com.project.ecommerce.model.Category;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, String> {

    @Override
    Optional<Category> findById(String s);

    @Override
    void delete(Category delete);
}
