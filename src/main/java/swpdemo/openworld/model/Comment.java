package swpdemo.openworld.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private Integer postId;

    @Column(nullable = true, length = 45)
    private String content;

    @Column(nullable = true)
    private Timestamp createAt;
}
