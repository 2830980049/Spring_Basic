package com.edu.Bean.DI;

public class SpEL_Product {
    private String name;
    private Double price;
    private SpEl_Category spElCategory;

    public SpEl_Category getSpElCategory() {
        return spElCategory;
    }

    public void setSpElCategory(SpEl_Category spElCategory) {
        this.spElCategory = spElCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + spElCategory +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
