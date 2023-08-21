package swpdemo.openworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import swpdemo.openworld.model.Notification;

public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}
