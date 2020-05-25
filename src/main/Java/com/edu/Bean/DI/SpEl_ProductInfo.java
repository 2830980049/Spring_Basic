package com.edu.Bean.DI;

public class SpEl_ProductInfo {
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Double totalPrice(){
        return price * 200;
    }
}
