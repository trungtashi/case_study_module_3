package dao;

import model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomePageDAO implements IHomePage{
    private String jdbcURL="jdbc:mysql://localhost:3306/bookstore";
    private String jdbcUsername="root";
    private String jdbcPassword="123456";

    private static final String SELECT_ALL_BOOKS="select * from books";
    private static final String SELECT_BOOKS_BY_NAME = "select * from books where name like ?";
    public HomePageDAO() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public List<Book> selectAllBooks() {
        List<Book> books = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS)){
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                String author=resultSet.getString("author");
                Double price=resultSet.getDouble("price");
                String image=resultSet.getString("image");
                String description=resultSet.getString("description");
                books.add(new Book(name,author,price,image,description));
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return books;
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
                String name=resultSet.getString("name");
                String author=resultSet.getString("author");
                Double price=resultSet.getDouble("price");
                String image=resultSet.getString("image");
                String description=resultSet.getString("description");
                books.add(new Book(name,author,price,image,description));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
