package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.TypeReact;

public interface ITypeReactRepository extends JpaRepository<TypeReact, Integer> {
}
