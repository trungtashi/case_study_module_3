package model;

public class OrderDetail {
    private int id;
    private int orders_id;
    private int book_id;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(int id, int orders_id, int book_id, int quantity) {
        this.id = id;
        this.orders_id = orders_id;
        this.book_id = book_id;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrders_id() {
        return orders_id;
    }

    public void setOrders_id(int orders_id) {
        this.orders_id = orders_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", orders_id=" + orders_id +
                ", book_id=" + book_id +
                ", quantity=" + quantity +
                '}';
    }
}
