package dao;

import model.Book;

import java.util.List;

public interface IHomePage {

    public List<Book> selectAllBooks();
    List<Book> searchByName(String input_name);
}
