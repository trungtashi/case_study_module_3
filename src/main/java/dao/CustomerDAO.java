package dao;


import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static connection.ConnectionCMS.getConnection;

public class CustomerDAO implements ICustomerDAO{
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (`name`,address,phone,email,account,password) VALUES (?, ?, ?,?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select id,`name`,address,email,phone,account,password from customer where id=?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set `name` = ?,address=?,phone=?,email= ?,account=?,password=? where id = ?;";
    private static final String SEARCH_CUSTOMER_BY_NAME = "select * from customer where `name` like ?";
    private static final String SORT_BY_NAME = "select * from customer order by `name`";
    public CustomerDAO() {
    }
    public void insertCustomer(Customer customer) {
        System.out.println(INSERT_CUSTOMER_SQL);
        //câu lệnh try-with-resource sẽ tự động đóng kết nối.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getName());
            preparedStatement.setString(2, customer.getAddress());
            preparedStatement.setString(3,customer.getPhone());
            preparedStatement.setString(4,customer.getEmail());
            preparedStatement.setString(5,customer.getAccount());
            preparedStatement.setString(6,customer.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Bước 1: Thiết lập kết nối
        try (Connection connection = getConnection();
             //Bước 2:Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Bước 3: Thực thi truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Bước 4: Xử lý đối tượng ResultSet
            while (rs.next()) {
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String account = rs.getString("account");
                String password = rs.getString("password");
                customer = new Customer(name,address,address,phone,email,account,password);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }
    public List<Customer> selectAllCustomer() {

        // sử dụng try-with-resources để tránh đóng tài nguyên
        List<Customer> customers = new ArrayList<>();
        // Step 1: Thiết lập kết nối
        try (Connection connection = getConnection();

             // Step 2:Tạo một câu lệnh bằng cách sử dụng đối tượng kết nối
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
            System.out.println(preparedStatement);
            // Step 3: Thực thi truy vấn hoặc cập nhật truy vấn
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Xử lý đối tượng ResultSet
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");;
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String account = rs.getString("account");
                String password = rs.getString("password");
                customers.add(new Customer( id,  name,address,phone,email,account,password));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        return customers;
    }
    public boolean deleteCustomer(int id){
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Xoa that bai");
        }
        return rowDeleted;
    }

    public boolean updateCustomer(Customer customer){
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getAddress());
            statement.setString(3,customer.getEmail());
            statement.setString(4,customer.getPhone());
            statement.setString(5,customer.getAccount());
            statement.setString(6,customer.getPassword());
            statement.setInt(7,customer.getId());
            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Cap nhat that bai");
        }
        return rowUpdated;
    }
    @Override
    public List<Customer> searchCustomerByName(String inputName) {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement pstm = connection.prepareStatement(SEARCH_CUSTOMER_BY_NAME);
            pstm.setString(1, "%"+inputName+"%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String account = rs.getString("account");
                String password = rs.getString("password");
                customers.add(new Customer( id,  name,address,phone,email,account,password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
    @Override
    public List<Customer> sortByName() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement pstm = connection.prepareStatement(SORT_BY_NAME);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String account = rs.getString("account");
                String password = rs.getString("password");
                customers.add(new Customer( id,  name,address,phone,email,account,password));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
