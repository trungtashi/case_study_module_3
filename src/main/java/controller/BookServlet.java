package controller;

import dao.BookDAO;
import model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BookServlet", value = "/books")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDAO bookDAO;
    public void init(){
        bookDAO = new BookDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action="";
        }
        try{
            switch (action){
                case"create":
                    insertBook(request,response);
                    break;
                case"edit":
                    updateBook(request,response);
                    break;
                case"search":
                    searchBook(request,response);
                    break;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
                    deleteBook(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }



    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
                List<Book> listBook= bookDAO.selectAllBooks();
                request.setAttribute("listBook",listBook);
                RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
               dispatcher.forward(request,response);
    }
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
        dispatcher.forward(request,response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book  existingBook = bookDAO.selectBook(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/edit.jsp");
        request.setAttribute("book",existingBook);
        dispatcher.forward(request,response);
    }
    private void insertBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {

        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String author= request.getParameter("author");
        Double price= Double.valueOf(request.getParameter("price"));
        String image=request.getParameter("image");
        String description=request.getParameter("description");
        Book newBook= new Book(code,name,author,price,image,description);
        bookDAO.insertBook(newBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/create.jsp");
        dispatcher.forward(request, response);
    }
    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String author=request.getParameter("author");
        Double price = Double.valueOf(request.getParameter("price"));
        String image= request.getParameter("image");
        String description=request.getParameter("description");
        Book book = new Book(id,code,name,author,price,image,description);
        bookDAO.updateBooks(book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/edit.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookDAO.deleteBook(id);
        List<Book> listBook = bookDAO.selectAllBooks();
        request.setAttribute("listBook",listBook);
        RequestDispatcher dispatcher =request.getRequestDispatcher("book/list.jsp");
        dispatcher.forward(request,response);
    }
private void searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String name = request.getParameter("search");
        List<Book> books = bookDAO.searchByName(name);
        request.setAttribute("listBook", books);
        RequestDispatcher dispatcher = request.getRequestDispatcher("book/list.jsp");
        dispatcher.forward(request, response);
}
}
