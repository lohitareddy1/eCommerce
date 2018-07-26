package com.project.ecommerce.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "orderlineitem")
public class OrderLineItem {

     @Id
    private ObjectId _id;
    private int quantity;
    private String displayName;
    private String displayTitle;
    private String summary;
    private String mfgId;

    public OrderLineItem(ObjectId _id, int quantity, String displayName, String displayTitle, String summary, String mfgId) {
        this._id = _id;
        this.quantity = quantity;
        this.displayName = displayName;
        this.displayTitle = displayTitle;
        this.summary = summary;
        this.mfgId = mfgId;
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayTitle() {
        return displayTitle;
    }

    public void setDisplayTitle(String displayTitle) {
        this.displayTitle = displayTitle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getMfgId() {
        return mfgId;
    }

    public void setMfgId(String mfgId) {
        this.mfgId = mfgId;
    }
}
