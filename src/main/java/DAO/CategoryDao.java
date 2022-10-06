package DAO;

import connection.ConnectionCMS;
import model.Book;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static connection.ConnectionCMS.getConnection;

public class CategoryDao implements ICategory {
    private static final String INSERT_CATEGORY_SQL = "INSERT INTO category (type, description) VALUES (?, ?);";
    private static final String SELECT_ALL_CATEGORY = "select * from category";
    private static final String DELETE_CATEGORY_SQL = "delete from category where id = ?;";
    private static final String UPDATE_CATEGORY_SQL = "update category set type = ?, description= ? where id = ?;";

public CategoryDao(){

}


    @Override
    public void insertCategory(Category category) throws SQLException {
        System.out.println(INSERT_CATEGORY_SQL);
        try {
            Connection connection  = ConnectionCMS.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL);
            preparedStatement.setString(1, category.getType());
            preparedStatement.setString(2, category.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    private void printSQLException(SQLException e) {

    }

    @Override
    public Book selectCategory(int id) {
        return null;
    }

    @Override
    public List<Category> selectAllCategory() {
        return null;
    }

    @Override
    public boolean deleteCategory(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCategory(Category category) throws SQLException {
        return false;
    }
}
