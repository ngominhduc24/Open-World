package swpdemo.openworld.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private Integer id;
    private String postId;
    private String content;
    private Timestamp createAt;
    private Integer totalReact;
}
