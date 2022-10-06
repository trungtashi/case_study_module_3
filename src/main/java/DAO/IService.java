package dao;

import model.Customer;

import java.util.List;

public interface IService<T> {
    List<T> selectAll();
    List<T> selectByName(String name);
    void delete(int id);
    void save(T t);
    void update(int id,T t);
    public T findByID(int id);
}
