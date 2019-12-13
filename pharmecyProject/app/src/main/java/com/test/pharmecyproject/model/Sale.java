package com.test.pharmecyproject.model;

import com.google.gson.annotations.SerializedName;

public class Sale {

    private  int id;

    @SerializedName("name")
    private String name;
    @SerializedName("qty")
    private double qty;
    @SerializedName("price")
    private double price;
    @SerializedName("subTotal")
    private double subTotal;
    @SerializedName("discount")
    private double discount;
    @SerializedName("total")
    private double total;

    public Sale() {
    }

    public Sale(int id, String name, double qty, double price, double subTotal, double discount, double total) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.subTotal = subTotal;
        this.discount = discount;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
