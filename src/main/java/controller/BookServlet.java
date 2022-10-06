package controller;

import model.Book;
import model.Category;
import dao.book.BookService;
import dao.book.IBookDAO;
import dao.category.CategoryService;
import dao.category.ICategoryDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (name = "BookServlet" , urlPatterns = "/books")
public class BookServlet extends HttpServlet {
    IBookDAO bookDAO = new BookService();
    BookService bookService = new BookService();
    ICategoryDAO categoryDAO = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action="";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showEditBook(req, resp);
                break;
            case "findByName":
                selectBookByName(req, resp);
                break;
            case "findById":
                selectBookById(req, resp);
                break;
            case "delete":
                try {
                    deleteBook(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "showFindForm":
                showFindForm(req, resp);
                break;
            case "showFindFormId":
                showFindFormId(req, resp);
                break;
            default:
                showAllBook(req, resp);
                break;
        }
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.delete(id);
        List<Book> books = bookService.selectAll();
        request.setAttribute("books", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/listBook.jsp");
        dispatcher.forward(request, response);
    }
    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/create.jsp");
        req.setAttribute("categories", categoryDAO.selectAll());

        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/edit.jsp");
        request.setAttribute("book", book);
        request.setAttribute("categories", categoryDAO.selectAll());
        request.setAttribute("selectCategory", book.getCategories());
        dispatcher.forward(request, response);
    }
    private void showAllBook(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/listBook.jsp");
        List<Book> books = bookDAO.selectAll();
        req.setAttribute("books", books);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFindForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("book/findForm.jsp");
        requestDispatcher.forward(req,resp);
    }
    private void showFindFormId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("book/findForm.jsp");
        requestDispatcher.forward(req,resp);
    }
    private void selectBookByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/viewBook.jsp");
        String name = req.getParameter("name");
        List<Book> books = bookDAO.selectByName(name);
        req.setAttribute("books", books);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void selectBookById(HttpServletRequest req, HttpServletResponse resp){
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/viewBook.jsp");
        int id = Integer.parseInt(req.getParameter("id"));
        Book book = bookService.selectById(id);
        List<Book> books = new ArrayList<>();
        books.add(book);
        req.setAttribute("books", books);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action ="";
        }
        switch (action) {
            case "create":
                createNewBook(req, resp);
                break;
            case "edit":
                try {
                    updateBook(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "findByName":
                break;
            default:
                showAllBook(req,resp);
                break;
        }
    }

    private void createNewBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        double price = Double.parseDouble(req.getParameter("price"));
        String image = req.getParameter("image");
        String description = req.getParameter("description");
        String[] categoriesStr = req.getParameterValues("categories");
        int[] categories = new int[categoriesStr.length];
        for (int i = 0; i < categoriesStr.length; i++) {
            categories[i] = Integer.parseInt(categoriesStr[i]);
        }
        Book book = new Book(id, code, name, author, price, image, description);
        bookDAO.saves(book, categories);
        resp.sendRedirect("/books");
    }
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        List<Category> categories = new ArrayList<>();
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String author = request.getParameter("author");
        double price = Double.parseDouble(request.getParameter("price"));
        String image = request.getParameter("image");
        String description = request.getParameter("description");
        String[] categoriesStr = request.getParameterValues("categories");
        int[] categories = new int[categoriesStr.length];
        for (int i = 0; i < categoriesStr.length; i++) {
            categories[i] = Integer.parseInt(categoriesStr[i]);
        }
        Book book = new Book(id, code, name, author, price, image, description);
        bookService.updates(book, categories);

//        RequestDispatcher dispatcher = request.getRequestDispatcher("book/edit.jsp");
//        dispatcher.forward(request,response);
        response.sendRedirect("/books");
    }

}
