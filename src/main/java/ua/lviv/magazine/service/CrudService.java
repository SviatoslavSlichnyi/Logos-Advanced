package ua.lviv.magazine.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    T save(T t);

    T findById(long id);

    T update(T t);

    void deleteById(long id);

    void deleteAll();

    List<T> findAll();
}
