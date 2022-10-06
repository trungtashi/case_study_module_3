package controller;

import model.Customer;
import dao.customer.CustomerDAO;
import dao.customer.ICustomerDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    ICustomerDAO customerDAO = new CustomerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showRegisterPage(request, response);
                break;
            case "login":
                showCustomerPage(request, response);
            case "logout":
                logoutSystem(request,response);
                break;
            default:
                showLoginPage(request, response);
        }
    }

    private void logoutSystem(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("acc");
        session.removeAttribute("cart");
        response.sendRedirect("homepage.jsp");
    }

    private void showRegisterPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/login/register.jsp");
        dispatcher.forward(request, response);
    }

    private void showLoginPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/login/login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createNewCustomer(request, response);
                break;
            case "login":
                showCustomerPage(request, response);
                break;
            default:
                showLoginPage(request, response);
        }
    }

    private void showCustomerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        if (checkAdminLogin(account, password) == true) {
            request.getRequestDispatcher("/website/admin/adminPage.jsp").forward(request, response);
        } else {
            if (checkAccountLogin(account, password) == false) {
                request.setAttribute("mess", "Wrong User or Password");
                RequestDispatcher dispatcher = request.getRequestDispatcher("/website/login/login.jsp");
                dispatcher.forward(request, response);
            } else {
                Customer customer = customerDAO.findCustomerByAccount(account);
                HttpSession session = request.getSession();
                session.setAttribute("acc",customer);
                request.getRequestDispatcher("/website/customer/homepageCustomer.jsp").forward(request, response);
            }
        }
    }

    private void createNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer = null ;
        int id = (int) Math.floor(Math.random() * 100);
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("inlineRadioOptions");
        String gender = request.getParameter("address");
        String email = request.getParameter("phone");
        String phone = request.getParameter("email");
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Date now = Date.valueOf(LocalDate.now());
        if (checkAccountAvailable(account)) {
            customer = new Customer(id, name, age, address, gender, email, phone, account, password, now);
            customerDAO.save(customer);
            request.setAttribute("mess", "Create Succesfull");
        } else {
            request.setAttribute("mess", "Account Has Been Used");
        }
        HttpSession session = request.getSession();
        session.setAttribute("acc",customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/login/register.jsp");
        dispatcher.forward(request, response);
    }

    private boolean checkAccountAvailable(String account) {
        boolean check = true;
        List<Customer> customerList = customerDAO.selectAll();
        for (int i = 0; i < customerList.size(); i++) {
            if (account.equals(customerList.get(i).getAccount())) {
                check = false;
            }
        }
        return check;
    }

    private boolean checkAccountLogin(String account, String password) {
        boolean check = false;
        List<Customer> customerList = customerDAO.selectAll();
        for (int i = 0; i < customerList.size(); i++) {
            if (account.equals(customerList.get(i).getAccount()) && password.equals(customerList.get(i).getPassword())) {
                check = true;
            }
        }
        return check;
    }

    private boolean checkAdminLogin(String account, String password) {
        boolean check = false;
        if (account.equals("admin") && password.equals("admin")) {
            check = true;
        }
        return check;
    }
}
