package swpdemo.openworld.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "react")
public class React {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private Integer typeId;

    @Column(nullable = true)
    private Integer accountId;

    @Column(nullable = true)
    private Integer postId;

    @Column(nullable = true, length = 45)
    private String commentId;

    @Column(nullable = true)
    private String createAt;
}
