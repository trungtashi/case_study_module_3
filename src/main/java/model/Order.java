package model;

import java.sql.Date;

public class Order {
    private int id;
    private int customer_id;
    private Date dateBuy;

    public Order() {
    }

    public Order(int id, int customer_id, Date dateBuy) {
        this.id = id;
        this.customer_id = customer_id;
        this.dateBuy = dateBuy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", dateBuy=" + dateBuy +
                '}';
    }
}

