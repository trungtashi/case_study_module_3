package model;

import java.util.List;

public class Book {
    private int bookId;
    private String bookCode;
    private String bookName;
    private String bookAuthor;
    private double bookPrice;
    private String bookImage;
    private String bookDescription;

    public Book(int bookId, String bookCode, String bookName, String bookAuthor, double bookPrice, String bookImage, String bookDescription) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookImage = bookImage;
        this.bookDescription = bookDescription;
    }

    public Book(int bookId, String bookCode, String bookName, String bookAuthor, double bookPrice, String bookImage, String bookDescription, List<Category> categories) {
        this.bookId = bookId;
        this.bookCode = bookCode;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookImage = bookImage;
        this.bookDescription = bookDescription;
        this.categories = categories;
    }

    private List<Category> categories;

    public Book() {
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
