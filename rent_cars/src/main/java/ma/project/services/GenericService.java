package ma.project.services;

import lombok.AllArgsConstructor;
import ma.project.Repositories.GenericRepository;
import ma.project.iservices.IMetier;
import ma.project.metier.IAbstarct;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Transactional
@AllArgsConstructor
public class GenericService<T extends IAbstarct> implements IMetier<T> {
    private GenericRepository<T> genericRepository;

    @Override
    public T save(T object) {
        return genericRepository.save(object);
    }

    @Override
    public T update(T object) {
        if (!Objects.isNull(object.getId())) {
            T subObject = genericRepository.save(object);
            subObject.setUpdateDate(new Date());
            return subObject;
        }
        return null;
    }

    @Override
    public void delete(T object) {
        T subObject = this.findById(object.getId());
        subObject.setDeleteDate(new Date());
    }

    @Override
    public List<T> findAll() {
        return genericRepository.findAll().stream().filter(t -> t.getDeleteDate() == null).toList();
    }

    @Override
    public T findById(Long id) {
        return genericRepository.findById(id).orElse(null);
    }
}
