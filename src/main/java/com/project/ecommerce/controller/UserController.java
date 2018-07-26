package com.project.ecommerce.controller;

import com.project.ecommerce.model.User;
import com.project.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(method=RequestMethod.GET, value="/users")
    public Iterable<User> address() {
        return userRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/users")
    public String save(@RequestBody User address) {
        userRepository.save(address);

        return address.get_id();
    }

    @RequestMapping(method=RequestMethod.GET, value="/users/{id}")
    public User show(@PathVariable String id) {
        Optional<User> p = userRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/users/{id}")
    public User update(@PathVariable String id, @RequestBody User address) {

        Optional<User> addr = userRepository.findById(id);
        if (addr == null)
            return null;

        if(address.getFirstName() != null)
            addr.get().setFirstName(address.getFirstName());
        if(address.getLastName() != null)
            addr.get().setLastName(address.getLastName());
        if(address.getEmail() != null)
            addr.get().setEmail(address.getEmail());
        if(address.getAddress() != null)
            addr.get().setAddress(address.getAddress());
        if(address.getPhoneNumber() != null)
            addr.get().setPhoneNumber(address.getPhoneNumber());
        userRepository.save(addr.get());
        return addr.get();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/users/{id}")
    public String delete(@PathVariable String id) {
        Optional<User> p = userRepository.findById(id);
        if (p == null)
            return null;

        userRepository.delete(p.get());

        return "user deleted";
    }

}