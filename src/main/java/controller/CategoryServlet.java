package controller;

import DAO.CategoryDao;
import model.Category;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryServlet extends HttpServlet {
    private CategoryDao categoryDao;
    public void init(){
        categoryDao = new CategoryDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try{
            switch (action){
                case "create":
                    showNewForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    deleteCategory(request,response);
                    break;
                default:
                    listCategory(request,response);
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
        List<Category> listCategory = categoryDao.selectAllCategory();
        request.setAttribute("listCategory", listCategory);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/createCategory.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryDao.selectCategory(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/editCategory.jsp");
        request.setAttribute("category", category);
        dispatcher.forward(request, response);

    }

    private void insertCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String type = request.getParameter("type");
        String des = request.getParameter("description");
        Category category = new Category(type, des);
        categoryDao.insertCategory(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/createCategory.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        String des = request.getParameter("description");

        Category category = new Category(id, type, des);
        categoryDao.updateCategory(category);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/editCategory.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        categoryDao.deleteCategory(id);

        List<Category> categoryList = categoryDao.selectAllCategory();
        request.setAttribute("listCategory", categoryList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("category/listCategory.jsp");
        dispatcher.forward(request, response);
    }
}
