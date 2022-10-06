package dao.customer;
import dao.connection.Connection;
import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    java.sql.Connection connection = Connection.getConnection();
    private static final String SELECT_ALL_CUSTOMERS = "select * from customer where status = 'ACTIVATE' ;";
    private static final String INSERT_CUSTOMERS_SQL = "INSERT INTO customer (id,name,age,gender,address,phone,email,account,password,startdate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_CUSTOMER_BY_NAME = "select * from customer where name like ? ";
    private static final String DELETE_CUSTOMERS_SQL = "UPDATE customer set status = 'DISABLE' where id = ?";
    private static final String UPDATE_CUSTOMERS_DETAIL = "update customer set name = ?,age = ?, gender = ?, address = ?, phone = ?, email = ? where id = ?;";
    private static final String UPDATE_PASSWORD_CUS = "update customer set password = ? where id = ?;";
    private static final String FIND_CUSTOMER_BY_ID = "select * from customer where id = ?;";


    public CustomerDAO() {
    }

    @Override
    public List<Customer> selectAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_CUSTOMERS);
            System.out.println(statement);
            ResultSet resultSet1 = statement.executeQuery();
            while (resultSet1.next()) {
                int id = resultSet1.getInt("id");
                String name = resultSet1.getString("name");
                int age = resultSet1.getInt("age");
                String gender = resultSet1.getString("gender");
                String address = resultSet1.getString("address");
                String phone = resultSet1.getString("phone");
                String email = resultSet1.getString("email");
                String account = resultSet1.getString("account");
                String password = resultSet1.getString("password");
                Date startDate = resultSet1.getDate("startdate");
                customerList.add(new Customer(id, name, age, gender, address, phone, email, account, password, startDate));
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println("Error In SQL");
        }
        return customerList;
    }

    @Override
    public List<Customer> selectByName(String name) {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_CUSTOMER_BY_NAME);
            statement.setString(1, "%" + name + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                Date startDate = resultSet.getDate("startdate");
                Customer customer = new Customer(id, name1, age, gender, address, phone, email, account, password, startDate);
                customerList.add(customer);
                System.out.println(customerList.size());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public Customer findByID(int id) {
        Customer customer = null;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_CUSTOMER_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name1 = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                String account = resultSet.getString("account");
                String password = resultSet.getString("password");
                Date startDate = resultSet.getDate("startdate");
                customer = new Customer(id, name1, age, gender, address, phone, email, account, password, startDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMERS_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Disable Customer Successfull !");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMERS_SQL);
            statement.setInt(1, customer.getId());
            statement.setString(2, customer.getName());
            statement.setInt(3, customer.getAge());
            statement.setString(4, customer.getGender());
            statement.setString(5, customer.getAddress());
            statement.setString(6, customer.getPhone());
            statement.setString(7, customer.getEmail());
            statement.setString(8, customer.getAccount());
            statement.setString(9, customer.getPassword());
            statement.setDate(10, customer.getStartDate());
            statement.executeUpdate();
            System.out.println("Thanh cong");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void update(int id, Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMERS_DETAIL);
            statement.setString(1, customer.getName());
            statement.setInt(2, customer.getAge());
            statement.setString(3, customer.getGender());
            statement.setString(4, customer.getAddress());
            statement.setString(5, customer.getPhone());
            statement.setString(6, customer.getEmail());
            statement.setInt(7, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changePasswordCustomer(int id, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_PASSWORD_CUS);
            statement.setString(1, password);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer findCustomerByAccount(String account) {
        try {
            PreparedStatement statement = connection.prepareStatement("select * from customer where account = ?;");
            statement.setString(1,account);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name1 = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                Date startDate = resultSet.getDate("startdate");
                String password = resultSet.getString("password");
                Customer customer = new Customer(id, name1, age, gender, address, phone, email, account, password, startDate);
                return customer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ICustomerDAO customerDAO = new CustomerDAO();
        customerDAO.delete(1);
    }
}