package com.project.ecommerce.repositories;


import com.project.ecommerce.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrdersRepository extends CrudRepository<Orders, String> {

    @Override
    Optional<Orders> findById(String s);

    @Override
    void delete(Orders delete);
}