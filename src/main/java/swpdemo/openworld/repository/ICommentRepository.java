package swpdemo.openworld.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swpdemo.openworld.model.Comment;

@Repository
public interface ICommentRepository extends JpaRepository<Comment, Integer> {
    public Slice<Comment> findByPostId(Integer postId, Pageable pageable);

    @Query(value = "select count(*)\n" +
            "from comment where post_id = ?1", nativeQuery = true)
    Integer countAllByPostId(Integer integer);
}
