package com.project.ecommerce.controller;

import com.project.ecommerce.model.OrderLineItem;
import com.project.ecommerce.repositories.OrderLineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderLineItemController {

    @Autowired
    OrderLineItemRepository orderLineItemRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/orderlineitem")
    public Iterable<OrderLineItem> orderlineitem() {
        return orderLineItemRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/orderlineitem")
    public String save(@RequestBody OrderLineItem orderlineitem) {
        orderLineItemRepository.save(orderlineitem);

        return orderlineitem.get_id();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orderlineitem/{id}")
    public OrderLineItem show(@PathVariable String id) {
        Optional<OrderLineItem> p = orderLineItemRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/orderlineitem/{id}")
    public OrderLineItem update(@PathVariable String id, @RequestBody OrderLineItem orderlineitem) {

        Optional<OrderLineItem> addr = orderLineItemRepository.findById(id);
        if (addr == null)
            return null;

        if (orderlineitem.getQuantity() != 0)
            addr.get().setQuantity(orderlineitem.getQuantity());
        if (orderlineitem.getDisplayName() != null)
            addr.get().setDisplayName(orderlineitem.getDisplayName());
        if (orderlineitem.getDisplayTitle() != null)
            addr.get().setDisplayTitle(orderlineitem.getDisplayTitle());
        if (orderlineitem.getSummary() != null)
            addr.get().setSummary(orderlineitem.getSummary());
        if (orderlineitem.getMfgId() != null)
            addr.get().setMfgId(orderlineitem.getMfgId());
        orderLineItemRepository.save(addr.get());
        return addr.get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/orderlineitem/{id}")
    public String delete(@PathVariable String id) {
        Optional<OrderLineItem> p = orderLineItemRepository.findById(id);
        if (p == null)
            return null;

        orderLineItemRepository.delete(p.get());

        return "orderlineitem deleted";
    }

}