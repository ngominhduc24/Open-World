package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Profile;

public interface IProfile extends JpaRepository<Profile, Integer> {
}
