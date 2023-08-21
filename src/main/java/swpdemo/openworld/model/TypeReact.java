package swpdemo.openworld.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "type_react")
public class TypeReact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true, length = 100)
    private String name;
}
