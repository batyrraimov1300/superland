package com.example.superland.Domain;

public class PizzaDomain {

    private String title;
    private String pic;
    private String description;
    private String price;
    private String size;

    public PizzaDomain(String title, String pic, String description, String price, String size) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
        this.size = size;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
