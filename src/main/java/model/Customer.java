package model;

public class Customer {
    private int customerId;
    private String customerName;
    private int customerAge;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String account;
    private String password;

    public Customer(int customerId, String customerName, int customerAge, String customerAddress, String customerPhone, String customerEmail, String account) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.account = account;
    }

    public Customer(int customerId, String customerName, int customerAge, String customerAddress, String customerPhone, String customerEmail, String account, String password) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.account = account;
        this.password = password;
    }

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(int customerAge) {
        this.customerAge = customerAge;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerAge=" + customerAge +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
