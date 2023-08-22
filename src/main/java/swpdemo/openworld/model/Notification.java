package swpdemo.openworld.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private String accountId;

    @Column(nullable = true, length = 450)
    private String content;

    @Column(nullable = true)
    private String notificationDate;

    @Column(nullable = true)
    private Integer isRead;
}
