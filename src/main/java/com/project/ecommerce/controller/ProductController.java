package com.project.ecommerce.controller;

import com.project.ecommerce.model.Product;
import com.project.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @RequestMapping(method=RequestMethod.GET, value="/products")
    public Iterable<Product> product() {
        return productRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, value="/products")
    public String save(@RequestBody Product product) {
        productRepository.save(product);

        return product.get_id();
    }

    @RequestMapping(method=RequestMethod.GET, value="/products/{id}")
    public Product show(@PathVariable String id) {
        Optional<Product> p = productRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
    public Product update(@PathVariable String id, @RequestBody Product product) {

        Optional<Product> prod = productRepository.findById(id);
        if (prod == null)
            return null;

        if(product.getProdName() != null)
            prod.get().setProdName(product.getProdName());
        if(product.getProdDesc() != null)
            prod.get().setProdDesc(product.getProdDesc());
        if(product.getProdPrice() != null)
            prod.get().setProdPrice(product.getProdPrice());
        if(product.getProdImage() != null)
            prod.get().setProdImage(product.getProdImage());
        productRepository.save(prod.get());
        return prod.get();
    }

    @RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
    public String delete(@PathVariable String id) {
        Optional<Product> p = productRepository.findById(id);
        if (p == null)
            return null;

        productRepository.delete(p.get());

        return "product deleted";
    }
}