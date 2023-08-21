package swpdemo.openworld.model;

import jakarta.persistence.*;

import java.sql.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 45)
    private String username;

    @Column(nullable = false, length = 45)
    private String password;

    @Column(nullable = true)
    private Integer status;

    @Column(nullable = true)
    private Integer role;


    @Column(nullable = true)
    private Date createDate;
}
