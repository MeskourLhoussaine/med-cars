package ma.project.iservices;


import ma.project.metier.IAbstarct;

import java.util.List;

public interface IMetier<T extends IAbstarct> {
    T save(T object);

    T update(T object);

    void delete(T object);

    List<T> findAll();

    T findById(Long id);
}
