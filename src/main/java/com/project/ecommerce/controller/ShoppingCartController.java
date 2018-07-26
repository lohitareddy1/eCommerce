package com.project.ecommerce.controller;


import com.project.ecommerce.model.ShoppingCart;
import com.project.ecommerce.repositories.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @RequestMapping(method=RequestMethod.GET, value="/shoppingcarts")
    public Iterable<ShoppingCart> product() {
        return shoppingCartRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/shoppingcarts")
    public String save(@RequestBody ShoppingCart product) {
        shoppingCartRepository.save(product);

        return product.get_id();
    }

    @RequestMapping(method=RequestMethod.GET, value="/shoppingcarts/{id}")
    public ShoppingCart show(@PathVariable String id) {
        Optional<ShoppingCart> p = shoppingCartRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/shoppingcarts/{id}")
    public ShoppingCart update(@PathVariable String id, @RequestBody ShoppingCart product) {

        Optional<ShoppingCart> prod = shoppingCartRepository.findById(id);
        if (prod == null)
            return null;

        if(product.getOrderTotal() != 0)
            prod.get().setOrderTotal(product.getOrderTotal());
        if(product.getQuantity() != 0)
            prod.get().setQuantity(product.getQuantity());
        shoppingCartRepository.save(prod.get());
        return prod.get();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/shoppingcarts/{id}")
    public String delete(@PathVariable String id) {
        Optional<ShoppingCart> p = shoppingCartRepository.findById(id);
        if (p == null)
            return null;

        shoppingCartRepository.delete(p.get());

        return "shopping cart deleted";
    }
}