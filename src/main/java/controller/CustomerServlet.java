package controller;

import model.Book;
import model.Cart;
import model.Customer;
import dao.book.BookService;
import dao.book.IBookDAO;
import dao.customer.CustomerDAO;
import dao.customer.ICustomerDAO;
import dao.order.OrderDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    IBookDAO bookDAO = new BookService();
    ICustomerDAO customerDAO = new CustomerDAO();
    OrderDAO orderDAO = new OrderDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAllBook":
                showAllBook(req,resp);
                break;
            case "create":
                showListCreate(req, resp);
                break;
            case "showDetail":
                showUpdateDetailForm(req,resp);
                break;
            case "cart":
                showCart(req,resp);
                break;
            case "add":
                addBook(req, resp);
                break;
            case "edit":
//                editCart(req,resp);
                break;
            default:
                showHomePageCustomer(req, resp);
                break;
        }
    }

    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int id_book = Integer.parseInt(req.getParameter("id"));
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("acc");
        orderDAO.createOrderDetail(customer.getId(), id_book,1);
        List<Cart> cartList = orderDAO.getCart(customer.getId());
        int sum = 0;
        for (Cart x: cartList
        ) {
            sum += x.getTotalPrice();
        }
        req.setAttribute("sum",sum);
        req.setAttribute("cart1",cartList);
        req.getRequestDispatcher("website/customer/shoping-cart.jsp").forward(req,resp);
    }

    private void showCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        double sum = 0;
        HttpSession session = req.getSession();
        Customer customer = (Customer) session.getAttribute("acc");
        List<Cart> cartList = orderDAO.getCart(customer.getId());
        session.setAttribute("cart",cartList);
        for (Cart x: cartList
             ) {
            sum += x.getTotalPrice();
        }
        req.setAttribute("sum",sum);
        req.setAttribute("cart1",cartList);
        req.getRequestDispatcher("website/customer/shoping-cart.jsp").forward(req,resp);
    }

    private void showAllBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Book> books = bookDAO.selectAll();
        req.setAttribute("listPro",books);
        req.getRequestDispatcher("website/customer/productByCus.jsp").forward(req,resp);
    }

    private void showUpdateDetailForm(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/updateDetailCus.jsp");
        HttpSession session = request.getSession();
        Customer temp = (Customer)session.getAttribute("acc");
        Customer temp2 = customerDAO.findByID(temp.getId());
        request.setAttribute("thisCus",temp2);
        dispatcher.forward(request,response);
    }

    private void showListCreate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showHomePageCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            books.add(bookDAO.selectAll().get(i));
        }
        request.setAttribute("listPro1",books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/homepageCustomer.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "editDetail":
                editDetailCus(req,resp);
                break;
            default:
                showHomePageCustomer(req, resp);
                break;
        }
    }

    private void editDetailCus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer temp = customerDAO.findByID(id);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String gender = temp.getGender();
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Date now = temp.getStartDate();
        Customer customer = new Customer(id,name,age,gender,address,email,phone,account,password,now);
        customerDAO.update(id,customer);
        request.setAttribute("mess","Success !");
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/customer/updateDetailCus.jsp");
        dispatcher.forward(request, response);
    }
}

