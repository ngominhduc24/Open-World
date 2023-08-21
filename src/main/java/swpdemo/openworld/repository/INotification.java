package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Notification;

public interface INotification extends JpaRepository<Notification, Integer> {
}
