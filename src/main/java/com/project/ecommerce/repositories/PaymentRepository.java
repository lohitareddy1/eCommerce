package com.project.ecommerce.repositories;

import com.project.ecommerce.model.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PaymentRepository extends CrudRepository<Payment, String> {

    @Override
    Optional<Payment> findById(String s);

    @Override
    void delete(Payment delete);
}