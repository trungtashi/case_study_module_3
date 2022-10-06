package dao.customer;

import model.Customer;
import dao.IService;

public interface ICustomerDAO extends IService<Customer> {
    public Customer findCustomerByAccount(String account);
}
