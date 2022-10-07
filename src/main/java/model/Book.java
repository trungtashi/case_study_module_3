package model;

import java.util.List;

public class Book {
    private int id;
    private String code;
    private String name;
    private String author;
    private double price;
    private String image;
    private String description;
    private List<Category> categories;

    public Book(String code, String name, String author) {
    }

    public Book(String code, String name, String author, double price, String image, String description) {

        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public Book(int id, String code, String name, String author, double price, String image, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

}
