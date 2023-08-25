package swpdemo.openworld.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Friendship;

import java.util.List;

public interface IFriendshipRepository extends JpaRepository<Friendship, Integer> {
    Slice<Friendship> getFriendshipByAccountId1OrAccountId2(Integer accountId1, Integer accountId2, Pageable pageable);
}
