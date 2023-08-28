package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swpdemo.openworld.model.React;
@Repository
public interface IReactRepository extends JpaRepository<React, Integer> {
    Integer countAllByCommentId(Integer commentId);

    @Query(value = "select count(*)\n" +
            "from react where post_id = ?1", nativeQuery = true)
    Integer countAllByPostId(Integer postId);
    @Query(value = "select p.full_name\n" +
            "    from react r join profile p on r.account_id = p.account_id\n" +
            "    where post_id= ?1 order by r.create_at desc limit 1", nativeQuery = true)
    String findUserReact(Integer postId);
}
