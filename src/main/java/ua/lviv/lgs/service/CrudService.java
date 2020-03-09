package ua.lviv.lgs.service;

import java.sql.SQLException;
import java.util.List;

public interface CrudService<T> {

    T save(T t);

    T findById(Integer id);

    T update(T t);

    void delete(Integer id) throws SQLException;

    List<T> findAll();
}
