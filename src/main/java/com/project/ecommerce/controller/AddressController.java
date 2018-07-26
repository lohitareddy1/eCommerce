package com.project.ecommerce.controller;

import com.project.ecommerce.repositories.AddressRepository;
import com.project.ecommerce.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
public class AddressController {

    @Autowired
    AddressRepository addressRepository;

    @RequestMapping(method=RequestMethod.GET, value="/address")
    public Iterable<Address> address() {
        return addressRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/address")
    public String save(@RequestBody Address address) {
        addressRepository.save(address);

        return address.get_id();
    }

    @RequestMapping(method=RequestMethod.GET, value="/address/{id}")
    public Address show(@PathVariable String id) {
        Optional<Address> p = addressRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/address/{id}")
    public Address update(@PathVariable String id, @RequestBody Address address) {

        Optional<Address> addr = addressRepository.findById(id);
        if (addr == null)
            return null;

        if(address.getAddressLine1() != null)
            addr.get().setAddressLine1(address.getAddressLine1());
        if(address.getAddressLine2() != null)
            addr.get().setAddressLine2(address.getAddressLine2());
        if(address.getState() != null)
            addr.get().setState(address.getState());
        if(address.getCountry() != null)
            addr.get().setCountry(address.getCountry());
        if(address.getZipCode() != null)
            addr.get().setZipCode(address.getZipCode());
        addressRepository.save(addr.get());
        return addr.get();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/address/{id}")
    public String delete(@PathVariable String id) {
        Optional<Address> p = addressRepository.findById(id);
        if (p == null)
            return null;

        addressRepository.delete(p.get());

        return "address deleted";
    }

}