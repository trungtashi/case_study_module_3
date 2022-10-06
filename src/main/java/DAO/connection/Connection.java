package DAO.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static final String URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static java.sql.Connection Connection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("ket noi that bai");
            e.printStackTrace();
        }
        return connection;
    }
}
