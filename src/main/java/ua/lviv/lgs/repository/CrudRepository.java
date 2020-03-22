package ua.lviv.lgs.repository;

import java.util.List;

public interface CrudRepository<T> {
    T save(T t);

    T findById(Integer id);

    T update(T t);

    void delete(Integer id);

    List<T> findAll();
}
