package ua.lviv.lgs.magazine.service;

import java.util.List;

public interface CRUDService<T> {

    T save(T object);

    T findById(Integer id);

    T update(T object);

    T deleteById(Integer id);

    List<T> findAll();

}