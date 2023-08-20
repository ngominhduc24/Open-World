package swpdemo.openworld.model;

import jakarta.persistence.*;

@Entity
@Table(name = "userpost")
public class UserPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer accountId;

    @Column(nullable = true)
    private String createAt;

    @Column(nullable = true, length = 400)
    private String caption;

    @Column(nullable = true, length = 450)
    private String photoUrl;

    @Column(nullable = true, length = 45)
    private String postShareId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPostShareId() {
        return postShareId;
    }

    public void setPostShareId(String postShareId) {
        this.postShareId = postShareId;
    }
}
