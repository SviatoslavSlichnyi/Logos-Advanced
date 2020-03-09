package ua.lviv.lgs.service;

import java.util.List;

public interface CrudService<T> {

    T save(T t);

    T findById(Integer id);

    T update(T t);

    void delete(Integer id);

    List<T> findAll();
}
