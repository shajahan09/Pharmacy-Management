package com.test.pharmecyproject.model;

public class HomeListItem {
    String product_name;
    String image;
    double price;
    float weight;
    int quantity;


    public HomeListItem() {

    }


    public HomeListItem(String product_name, String image, double price, float weight, int quantity) {
        this.product_name = product_name;
        this.image = image;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
