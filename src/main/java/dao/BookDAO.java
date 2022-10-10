package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static connection.Connection.getConnection;

public class BookDAO implements IBookDAO{
    private static final String INSERT_BOOKS_SQL="INSERT INTO books(code,name,author,price,image,description)VALUES(?,?,?,?,?,?)";
    private static final String SELECT_BOOK_BY_ID="select code,name,author,price,image,description from books where id=?";
    private static final String SELECT_ALL_BOOKS="select * from books";
    private static final String DELETE_BOOKS_SQL="delete from books where id=?;";
    private static final String UPDATE_BOOKS_SQL="update books set code= ?, name= ?, author= ?, price= ?, image= ?, description= ?, where id= ?;";
    private static final String SELECT_BOOKS_BY_NAME = "select * from books where name like ?";
    public BookDAO() {
    }
    @Override
    public void insertBook(Book book) throws SQLException {
        System.out.println(INSERT_BOOKS_SQL);
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKS_SQL)){

            preparedStatement.setString(1,book.getCode());
            preparedStatement.setString(2,book.getName());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setDouble(4,book.getPrice());
            preparedStatement.setString(5,book.getImage());
            preparedStatement.setString(6,book.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        }catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Book selectBook(int id) {
        Book book = null;
        try(Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOK_BY_ID)){
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String code = resultSet.getString("code");
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                Double price = resultSet.getDouble("price");
                String image = resultSet.getString("image");
                String description = resultSet.getString("description");
                book=new Book(id,code,name,author,price,image,description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return book;
    }

    @Override
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String code =resultSet.getString("code");
                String name=resultSet.getString("name");
                String author=resultSet.getString("author");
                Double price=resultSet.getDouble("price");
                String image=resultSet.getString("image");
                String description=resultSet.getString("description");
                books.add(new Book(id,code,name,author,price,image,description));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
    }

    @Override
    public boolean deleteBook(int id) throws SQLException {
        boolean rowDeleted;
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOKS_SQL)){
            preparedStatement.setInt(1,id);
            rowDeleted = preparedStatement.executeUpdate()>0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBooks(Book book) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BOOKS_SQL)){
            preparedStatement.setString(1,book.getCode());
            preparedStatement.setString(2,book.getName());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.setDouble(4,book.getPrice());
            preparedStatement.setString(5,book.getImage());
            preparedStatement.setString(6,book.getDescription());
            preparedStatement.setInt(7,book.getId());
            rowUpdated = preparedStatement.executeUpdate() > 0;

        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List<Book> searchByName(String input_name) {
        List<Book> books = new ArrayList<>();
        Connection connection = getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKS_BY_NAME);
            preparedStatement.setString(1,"%"+input_name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String code=resultSet.getString("code");
                String name=resultSet.getString("name");
                String author=resultSet.getString("author");
                Double price=resultSet.getDouble("price");
                String image=resultSet.getString("image");
                String description=resultSet.getString("description");
                books.add(new Book(id,code,name,author,price,image,description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
