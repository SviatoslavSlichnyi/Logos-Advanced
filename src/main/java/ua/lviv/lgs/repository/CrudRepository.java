package ua.lviv.lgs.repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T> {
    T save(T t);

    T findById(Integer id);

    T update(T t);

    void delete(Integer id) throws SQLException;

    List<T> findAll();
}
