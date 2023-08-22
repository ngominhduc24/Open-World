package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.React;

public interface IReactRepository extends JpaRepository<React, Integer> {
}
