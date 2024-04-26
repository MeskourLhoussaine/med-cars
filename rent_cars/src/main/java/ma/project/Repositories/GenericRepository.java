package ma.project.Repositories;

import ma.project.metier.IAbstarct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends IAbstarct> extends JpaRepository<T, Long> {
}
