package swpdemo.openworld.dto;
import java.sql.Date;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private Integer id;
    private String fullName;
    private String username;
    private String password;
    private Integer status;
    private Integer role;
    private Date createDate;
    private Date dob;
    private Integer gender;
    private String avatarUrl;
    private String coverUrl;
    private String aboutMe;
    private String email;
    private String phone;
}
