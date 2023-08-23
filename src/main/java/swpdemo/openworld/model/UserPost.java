package swpdemo.openworld.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "userpost")
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer accountId;

    @Column(nullable = true)
    private Timestamp createAt;

    @Column(nullable = true, length = 400)
    private String caption;

    @Column(nullable = true, length = 450)
    private String photoUrl;

    @Column(nullable = true, length = 45)
    private String postShareId;
}
