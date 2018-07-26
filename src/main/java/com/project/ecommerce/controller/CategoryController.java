package com.project.ecommerce.controller;

import com.project.ecommerce.model.Category;
import com.project.ecommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/category")
    public Iterable<Category> category() {
        return categoryRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/category")
    public String save(@RequestBody Category category) {
        categoryRepository.save(category);

        return category.get_id();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{id}")
    public Category show(@PathVariable String id) {
        Optional<Category> p = categoryRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/category/{id}")
    public Category update(@PathVariable String id, @RequestBody Category category) {

        Optional<Category> addr = categoryRepository.findById(id);
        if (addr == null)
            return null;

        if (category.getName() != null)
            addr.get().setName(category.getName());
        categoryRepository.save(addr.get());
        return addr.get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/category/{id}")
    public String delete(@PathVariable String id) {
        Optional<Category> p = categoryRepository.findById(id);
        if (p == null)
            return null;

        categoryRepository.delete(p.get());

        return "category deleted";
    }

}