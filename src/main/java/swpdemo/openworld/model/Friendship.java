package swpdemo.openworld.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "friendship")
public class Friendship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private Integer accountId1;

    @Column(nullable = true)
    private Integer accountId2;

    @Column(nullable = true)
    private Integer actionAccountId;

    @Column(nullable = true)
    private String friendshipDate;

    @Column(nullable = true)
    private Integer status;
}
