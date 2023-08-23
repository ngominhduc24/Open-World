package swpdemo.openworld.dto;

import jakarta.persistence.Column;

import java.sql.Timestamp;

public class UserPostDTO {
    private Integer id;
    private Integer accountId;
    private Timestamp createAt;
    private String caption;
    private String photoUrl;
    private String postShareId;
    private Integer totalReact;
    private Integer totalComment;
    private Integer totalShare;
}
