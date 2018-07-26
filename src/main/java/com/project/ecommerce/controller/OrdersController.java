package com.project.ecommerce.controller;

import com.project.ecommerce.model.Orders;
import com.project.ecommerce.repositories.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrdersController {
    @Autowired
    OrdersRepository ordersRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/orders")
    public Iterable<Orders> orders() {
        return ordersRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orders")
    public String save(@RequestBody Orders orders) {
        ordersRepository.save(orders);

        return orders.get_id();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orders/{id}")
    public Orders show(@PathVariable String id) {
        Optional<Orders> p = ordersRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orders/{id}")
    public Orders update(@PathVariable String id, @RequestBody Orders orders) {

        Optional<Orders> addr = ordersRepository.findById(id);
        if (addr == null)
            return null;

        if (orders.getQuantity() != 0)
            addr.get().setQuantity(orders.getQuantity());
        if (orders.getTrackingNumber() != null)
            addr.get().setTrackingNumber(orders.getTrackingNumber());
        if (orders.getTotal() != 0)
            addr.get().setTotal(orders.getTotal());
        ordersRepository.save(addr.get());
        return addr.get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orders/{id}")
    public String delete(@PathVariable String id) {
        Optional<Orders> p = ordersRepository.findById(id);
        if (p == null)
            return null;

        ordersRepository.delete(p.get());

        return "order deleted";
    }

}