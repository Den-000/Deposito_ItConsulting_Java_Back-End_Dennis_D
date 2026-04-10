package controller.service;

public interface ICrud<T> {

    void create(T obj);

    T findById(int id);

    void update(int id, T obj);

    void delete(int id);

}
