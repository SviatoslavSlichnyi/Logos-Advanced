package ua.lviv.lgs.magazine.repository;

import java.util.List;

public interface CRUDRepository<T> {

    T save(T object);

    T findById(Integer id);

    T update(T object);

    T deleteById(Integer id);

    List<T> findAll();

}
