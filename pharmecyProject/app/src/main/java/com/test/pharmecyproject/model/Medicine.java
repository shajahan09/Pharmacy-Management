package com.test.pharmecyproject.model;

import com.google.gson.annotations.SerializedName;

public class Medicine {
    private  int id;

    @SerializedName("name")
    private String name;
    @SerializedName("qty")
    private double qty;
    @SerializedName("price")
    private double price;
//    @SerializedName("expdate")
//    private String expdate;
    @SerializedName("img")
    private String img;
    @SerializedName("catagory")
    private String catagory;
    @SerializedName("date")
    private String date;

    public Medicine() {
    }

    public Medicine(int id, String name, double qty, double price, String img, String catagory, String date) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.img = img;
        this.catagory = catagory;
        this.date = date;
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

//    public String getExpdate() {
//        return expdate;
//    }
//
//    public void setExpdate(String expdate) {
//        this.expdate = expdate;
//    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

//    public String getCatagory() {
//        return catagory;
//    }
//
//    public void setCatagory(String catagory) {
//        this.catagory = catagory;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
