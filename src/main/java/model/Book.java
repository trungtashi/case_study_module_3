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

    public Book() {
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

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
