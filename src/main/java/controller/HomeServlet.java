package controller;

import model.Book;
import dao.book.BookService;
import dao.book.IBookDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet", value = "/home")
public class HomeServlet extends HttpServlet {
    IBookDAO bookDAO = new BookService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "" ;
        }
        switch (action){
            case "contact":
                showContactPage(request,response);
                break;
            case "blog":
                showBlogPage(request,response);
                break;
            case "about":
                showAboutPage(request,response);
                break;
            case "product":
                showAllProduct(request,response);
                break;
            default:
                showHomePage(request,response);
        }
    }

    private void showAllProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        List<Book> books = bookDAO.selectAll();
        request.setAttribute("home",books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/product.jsp");
        dispatcher.forward(request, response);
    }

    private void showAboutPage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/about.jsp");
        dispatcher.forward(request, response);
    }
    private void showBlogPage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/blog.jsp");
        dispatcher.forward(request, response);
    }
    private void showContactPage(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher("website/contact.jsp");
        dispatcher.forward(request,response);
    }

    private void showHomePage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            books.add(bookDAO.selectAll().get(i));
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("homepage.jsp");
        request.setAttribute("listHome",books);
        dispatcher.forward(request,response);
    }
}
