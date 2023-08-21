package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Friendship;

public interface IFriendship extends JpaRepository<Friendship, Integer> {
}
