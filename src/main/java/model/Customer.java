package model;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String account;
    private String password;

    public Customer(int id, String name, String address, String phone, String email, String account, String password) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.account = account;
        this.password = password;
    }

    public Customer(String name, String address, String phone, String customerEmail, String email, String account, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = customerEmail;
    }

    public Customer(String name, String address, String phone, String email, String account, String password) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.account = account;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
