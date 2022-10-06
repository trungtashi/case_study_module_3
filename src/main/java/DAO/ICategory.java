package DAO;
import model.Book;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface ICategory {
        public void insertCategory(Category category) throws SQLException;

        public Book selectCategory(int id);

        public List<Category> selectAllCategory();

        public boolean deleteCategory(int id) throws SQLException;

        public boolean updateCategory(Category category) throws SQLException;
}
