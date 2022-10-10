package dao;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookDAO {
    public void insertBook(Book book) throws SQLException;

    public Book selectBook(int id);

    public List<Book> selectAllBooks();
    List<Book> searchByName(String input_name);

    public boolean deleteBook(int id) throws SQLException;

    public boolean updateBooks(Book book) throws SQLException;
}
