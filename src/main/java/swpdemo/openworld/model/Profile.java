package swpdemo.openworld.model;

import jakarta.persistence.*;

import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column( unique = true)
    private Integer accountId;

    @Column(nullable = true, length = 45)
    private String fullName;

    @Column(nullable = true)
    private Date dob;

    @Column(nullable = true, length = 500)
    private String avatarUrl;
    @Column(nullable = true, length = 500)
    private String coverUrl;

    @Column(nullable = true, length = 45)
    private String aboutMe;

    @Column(nullable = true, length = 100)
    private String email;

    @Column(nullable = true, length = 100)
    private String phone;

    @Column(nullable = true)
    private Integer gender;
}
