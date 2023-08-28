package swpdemo.openworld.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import swpdemo.openworld.model.UserPost;

import java.util.List;
@Repository
public interface IUserPostRepository extends JpaRepository<UserPost, Integer> {
    public List<UserPost> findAllPostsByAccountId(Integer accountId, Pageable pageable);
    @Query(value = "select count(*)\n" +
            "from userpost where post_share_id = ?1", nativeQuery = true)
    Integer countAllByPostShareId(Integer postShareId);
}
