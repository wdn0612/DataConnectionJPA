package com.dntech.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OrderDetails {

    @Id
    private String userId;
    private String orderDate;
    private String itemId;
    private String quantity;
    private String unitPrice;
    private String totalPrice;

    protected OrderDetails() {}

    public String getUserId() {
        return userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getItemId() {
        return itemId;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "userId='" + userId + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", itemId='" + itemId + '\'' +
                ", quantity='" + quantity + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                '}';
    }

}