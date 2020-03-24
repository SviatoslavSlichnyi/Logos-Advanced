package ua.lviv.lgs.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T> {

    T save(T t);

    Optional<T> findById(int id);

    T update(T t);

    void deleteById(int id);

    void deleteAll();

    List<T> findAll();
}
