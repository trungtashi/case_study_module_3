package dao;

import model.Customer;
import java.util.List;

public interface ICustomerDAO {
    void insertCustomer(Customer customer);

    Customer selectCustomer(int id);

    List<Customer> selectAllCustomer();

    List<Customer> searchCustomerByName(String inputName);

    List<Customer> sortByName();

    boolean deleteCustomer(int id);

    boolean updateCustomer(Customer customer);
}
