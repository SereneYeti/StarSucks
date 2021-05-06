package za.ac.iie.opsc.starsucks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class Order {
    private String productName;
    private String customerName;
    private String customerCell;
    private String orderData;

    public IntentHelper intentHelper = new IntentHelper();

    public Order() {

    }

    public Order(String productName, String customerName, String orderData) {
        this.productName = productName;
        this.customerName = customerName;
        this.orderData = orderData;
    }

    public Order(String productName, String customerName, String customerCell, String orderData) {
        this.productName = productName;
        this.customerName = customerName;
        this.customerCell = customerCell;
        this.orderData = orderData;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCell() {
        return customerCell;
    }

    public void setCustomerCell(String customerCell) {
        this.customerCell = customerCell;
    }

    public String getOrderData() {
        return orderData;
    }

    public void setOrderData(String orderData) {
        this.orderData = orderData;
    }


}
