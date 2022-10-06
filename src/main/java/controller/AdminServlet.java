package controller;

import model.Customer;
import dao.book.BookService;
import dao.book.IBookDAO;
import dao.customer.CustomerDAO;
import dao.customer.ICustomerDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    ICustomerDAO customerDAO = new CustomerDAO();
    IBookDAO bookDAO = new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAllBook":
                break;
            case "editBook":
                break;
            case "showAllCus":
                showAllCustomer(req, resp);
                break;
            case "editCustomer":
                showEditCustomer(req, resp);
                break;
            case "deleteCustomer":
                showDeleteCustomer(req, resp);
                break;
            default:
                showHomePageAdmin(req, resp);
        }
    }

    private void showDeleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Customer tempDel = customerDAO.findByID(id);
        req.setAttribute("delete", tempDel);
        RequestDispatcher dispatcher = req.getRequestDispatcher("website/admin/deleteCustomerForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showHomePageAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/admin/adminPage.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerDAO.findByID(id);
        request.setAttribute("thisCus", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/admin/updateCustomer.jsp");
        dispatcher.forward(request, response);
    }

    private void showAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerDAO.selectAll();
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/admin/customerList.jsp");
        request.setAttribute("cusList", customerList);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "showAllBook":
                break;
            case "editBook":
                break;
            case "showAllCus":
                showAllCustomer(req, resp);
                break;
            case "editCustomer":
                editCustomer(req, resp);
                break;
            case "deleteCustomer":
                deleteCustomer(req, resp);
                break;
            case "findName":
                searchCustomerByName(req,resp);
                break;
            default:
                showHomePageAdmin(req, resp);
        }
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String name = request.getParameter("findName");
        List<Customer> customers = customerDAO.selectByName(name);
        request.setAttribute("cusList",customers);
        request.getRequestDispatcher("website/admin/customerList.jsp").forward(request,response);
    }

    private void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        customerDAO.delete(id);
        showAllCustomer(req, resp);
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        Customer customer = new Customer(id, name, age, gender, address, phone, email, account, password, now);
        customerDAO.update(id, customer);
        request.setAttribute("mess", "Success !");
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/admin/updateCustomer.jsp");
        dispatcher.forward(request, response);
    }
}
