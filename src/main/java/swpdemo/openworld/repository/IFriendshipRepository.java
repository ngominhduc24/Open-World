package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Friendship;

public interface IFriendshipRepository extends JpaRepository<Friendship, Integer> {
}
