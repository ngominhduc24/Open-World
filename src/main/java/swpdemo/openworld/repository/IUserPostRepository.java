package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.UserPost;

public interface IUserPostRepository extends JpaRepository<UserPost, Integer> {
}
