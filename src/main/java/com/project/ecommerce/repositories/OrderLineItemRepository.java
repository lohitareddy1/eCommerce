package com.project.ecommerce.repositories;

import com.project.ecommerce.model.OrderLineItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface OrderLineItemRepository extends CrudRepository<OrderLineItem, String> {

    @Override
    Optional<OrderLineItem> findById(String s);

    @Override
    void delete(OrderLineItem delete);
}
