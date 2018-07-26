package com.project.ecommerce.controller;


import com.project.ecommerce.model.Payment;
import com.project.ecommerce.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentsRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/payments")
    public Iterable<Payment> payments() {
        return paymentsRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/payments")
    public String save(@RequestBody Payment orders) {
        paymentsRepository.save(orders);

        return orders.get_id();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/payments/{id}")
    public Payment show(@PathVariable String id) {
        Optional<Payment> p = paymentsRepository.findById(id);
        if (p != null)
            return p.get();
        return p.get();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/payments/{id}")
    public Payment update(@PathVariable String id, @RequestBody Payment payments) {

        Optional<Payment> addr = paymentsRepository.findById(id);
        if (addr == null)
            return null;

        if (payments.getPaymentMethod() != null)
            addr.get().setPaymentMethod(payments.getPaymentMethod());
        if (payments.getCardDetails() != null)
            addr.get().setCardDetails(payments.getCardDetails());
        paymentsRepository.save(addr.get());
        return addr.get();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/payments/{id}")
    public String delete(@PathVariable String id) {
        Optional<Payment> p = paymentsRepository.findById(id);
        if (p == null)
            return null;

        paymentsRepository.delete(p.get());

        return "payment deleted";
    }

}
