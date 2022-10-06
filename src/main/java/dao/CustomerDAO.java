package dao;


import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static connectJDBC.Connection.getConnection;

public class CustomerDAO implements ICustomerDAO{
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customer (customerName,customerAge,customerAddress,customerPhone,customerEmail,account,password) VALUES (?, ?, ?,?,?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select customerId,customerName,customerAge,customerAddress,customerEmail,customerPhone from customer where customerId=?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customer";
    private static final String DELETE_CUSTOMER_SQL = "delete from customer where customerId = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customerName = ?,customerAge=?,customerAddress=?customerEmail= ?, where customerId = ?;";
    private static final String SEARCH_CUSTOMER_BY_NAME = "select * from customer where customerName like ?";
    private static final String SORT_BY_NAME = "select * from customer order by customerName";
    public CustomerDAO() {
    }
    public void insertCustomer(Customer customer) {
        System.out.println(INSERT_CUSTOMER_SQL);
        //câu lệnh try-with-resource sẽ tự động đóng kết nối.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setString(1, customer.getCustomerName());
            preparedStatement.setInt(2, customer.getCustomerAge());
            preparedStatement.setString(3, customer.getCustomerAddress());
            preparedStatement.setString(4,customer.getCustomerPhone());
            preparedStatement.setString(5,customer.getCustomerEmail());
            preparedStatement.setString(6,customer.getAccount());
            preparedStatement.setString(7,customer.getPassword());
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
                String customerName = rs.getString("customerName");
                int customerAge = rs.getInt("customerAge");
                String customerAddress = rs.getString("customerAddress");
                String customerPhone = rs.getString("customerPhone");
                String customerEmail = rs.getString("customerEmail");
                String customerAccount = rs.getString("customerAccount");
                String customerPassword = rs.getString("customerPassword");
                customer = new Customer();
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
                int customerId = rs.getInt("customerId");
                String customerName = rs.getString("customerName");
                int customerAge = rs.getInt("customerAge");
                String customerAddress = rs.getString("customerAddress");
                String customerPhone = rs.getString("customerPhone");
                String customerEmail = rs.getString("customerEmail");
                String customerAccount = rs.getString("customerAccount");
                String customerPassword = rs.getString("customerPassword");
                customers.add(new Customer( customerId,  customerName,customerAge,customerAddress,customerPhone,customerEmail,customerAccount,customerPassword));
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
            statement.setInt(1,customer.getCustomerId());
            statement.setString(2, customer.getCustomerName());
            statement.setInt(3, customer.getCustomerAge());
            statement.setString(4, customer.getCustomerAddress());
            statement.setString(6,customer.getCustomerEmail());
            statement.setString(7,customer.getCustomerPhone());
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
                int customerId = rs.getInt("customerId");
                String customerName = rs.getString("customerName");
                int customerAge = rs.getInt("customerAge");
                String customerAddress = rs.getString("customerAddress");
                String customerPhone = rs.getString("customerPhone");
                String customerEmail = rs.getString("customerEmail");
                String customerAccount = rs.getString("customerAccount");
                String customerPassword = rs.getString("customerPassword");
                customers.add(new Customer( customerId,  customerName,customerAge,customerAddress,customerPhone,customerEmail,customerAccount,customerPassword));
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
                int customerId = rs.getInt("customerId");
                String customerName = rs.getString("customerName");
                int customerAge = rs.getInt("customerAge");
                String customerAddress = rs.getString("customerAddress");
                String customerPhone = rs.getString("customerPhone");
                String customerEmail = rs.getString("customerEmail");
                String customerAccount = rs.getString("customerAccount");
                String customerPassword = rs.getString("customerPassword");
                customers.add(new Customer( customerId,  customerName,customerAge,customerAddress,customerPhone,customerEmail,customerAccount,customerPassword));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }
}
