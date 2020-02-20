package ua.lviv.lgs.magazine.service;

public interface CRUDService<T> {

    T save(T t);

    T findById(Integer id);

    T updateById(Integer id);



}
