package controller;

import dao.CategoryDAO;
import model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;

    public void init() {
        categoryDAO = new CategoryDAO();
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
                    deleteCategory(request, response);
                    break;
                default:
                    listCategory(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertCategory(request, response);
                    break;
                case "edit":
                    updateCategory(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Category> listCategory = categoryDAO.selectAllCategory();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDAO.selectCategory(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/edit.jsp");
        request.setAttribute("category", category);
        dispatcher.forward(request, response);

    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String type = request.getParameter("type");
        String des = request.getParameter("description");
        Category category = new Category(type, des);
        categoryDAO.insertCategory(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        String des = request.getParameter("description");

        Category category = new Category(id, type, des);
        categoryDAO.updateCategory(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDAO.deleteCategory(id);

        List<Category> categoryList = categoryDAO.selectAllCategory();
        request.setAttribute("listCategory", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/list.jsp");
        dispatcher.forward(request, response);
    }
}
