package com.project.ecommerce.repositories;

import com.project.ecommerce.model.Address;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface AddressRepository extends CrudRepository<Address, String> {

@Override
    Optional<Address> findById(String s);

@Override
    void delete(Address delete);
            }