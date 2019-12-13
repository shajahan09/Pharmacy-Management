package com.test.pharmecyproject.model;

import com.google.gson.annotations.SerializedName;

public class Staff {

    private  int id;

@SerializedName("name")
    private String name;
    @SerializedName("bsalary")
    private double bsalary;
    @SerializedName("malw")
    private double malw;
    @SerializedName("total")
    private double total;
    @SerializedName("phone")
    private Integer phone;
    @SerializedName("userId")
    private Integer userId;


    public Staff() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
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

    public double getBsalary() {
        return bsalary;
    }

    public void setBsalary(double bsalary) {
        this.bsalary = bsalary;
    }

    public double getMalw() {
        return malw;
    }

    public void setMalw(double malw) {
        this.malw = malw;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
