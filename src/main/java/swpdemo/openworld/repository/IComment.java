package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Comment;

public interface IComment extends JpaRepository<Comment, Integer> {
}
