package com.edu.ShiWu.entity;

public class Product {
    private String id;
    private String title;
    private double price;
    private int stock;
    private String status;

    public Product() {
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status='" + status + '\'' +
                '}';
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Product(String id, String title, double price, int stock, String status) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.status = status;
    }
}
