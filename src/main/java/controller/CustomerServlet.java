package controller;


import dao.CustomerDAO;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CustomerDAO customerDAO;

    public void init() {
        customerDAO = new CustomerDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCustomerr(request, response);
                    break;
                case "edit":
                    updateCustomer(request, response);
                    break;
                case "search":
                    searchCustomerByName(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteCustomer(request, response);
                    break;
                case "sort":
                    sortCustomer(request, response);
                default:
                    listCustomer(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Customer> customers= customerDAO.selectAllCustomer();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        Customer existingCustomer = customerDAO.selectCustomer(customerId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        request.setAttribute("customers", existingCustomer);
        dispatcher.forward(request, response);

    }

    private void insertCustomerr(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Customer newCustomer = new Customer(customerName,customerAddress,customerPhone,customerEmail,account,password);
        customerDAO.insertCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        String customerPhone = request.getParameter("customerPhone");
        String customerEmail = request.getParameter("customerEmail");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Customer newCustomer = new Customer(customerName,customerAddress,customerPhone,customerEmail,account,password);
        customerDAO.updateCustomer(newCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        customerDAO.deleteCustomer(id);

        List<Customer> customers = customerDAO.selectAllCustomer();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchCustomerByName(HttpServletRequest request, HttpServletResponse response) throws SQLException,IOException,ServletException {
        String customerName = request.getParameter("input");
        List<Customer> customers = customerDAO.searchCustomerByName(customerName);
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void sortCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customerDAO.sortByName();
        request.setAttribute("customers", customers);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/sortbyname.jsp");
        dispatcher.forward(request, response);
    }
}
