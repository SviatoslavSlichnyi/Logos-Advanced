package ua.lviv.lgs.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    List<T> getAll();

    T save(T t);

    T update(T t);

    void delete(T t);
}
