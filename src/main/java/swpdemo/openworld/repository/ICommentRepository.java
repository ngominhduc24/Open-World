package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Integer> {
}
