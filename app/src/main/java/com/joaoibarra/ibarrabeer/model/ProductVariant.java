package com.joaoibarra.ibarrabeer.model;

/**
 * Created by joaoibarra on 08/04/18.
 */

public class ProductVariant {
    String title;
    String description;
    String imageUrl;
    double price;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPriceToString() {
        return Double.toString(price);
    }
}
