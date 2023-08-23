package swpdemo.openworld.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPostDTO {
    private Integer id;
    private Integer accountId;
    private Timestamp createAt;
    private String caption;
    private String photoUrl;
    private String postShareId;
    private String userComment;
    private Integer totalReact;
    private Integer totalComment;
    private Integer totalShare;
}
