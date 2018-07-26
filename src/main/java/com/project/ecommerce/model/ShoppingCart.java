package com.project.ecommerce.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shoppingcarts")
public class ShoppingCart {
    @Id
    private ObjectId _id;
    private int orderTotal;
    private int quantity;

    public ShoppingCart(ObjectId _id, int orderTotal, int quantity) {

        this._id = _id;
        this.orderTotal = orderTotal;
        this.quantity = quantity;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(int orderTotal) {
        this.orderTotal = orderTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}