package swpdemo.openworld.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Comment;


public interface ICommentRepository extends JpaRepository<Comment, Integer> {
    public Slice<Comment> findByPostId(Integer postId, Pageable pageable);
}
