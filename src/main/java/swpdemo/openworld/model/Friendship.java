package swpdemo.openworld.model;

import jakarta.persistence.*;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId1() {
        return accountId1;
    }

    public void setAccountId1(Integer accountId1) {
        this.accountId1 = accountId1;
    }

    public Integer getAccountId2() {
        return accountId2;
    }

    public void setAccountId2(Integer accountId2) {
        this.accountId2 = accountId2;
    }

    public Integer getActionAccountId() {
        return actionAccountId;
    }

    public void setActionAccountId(Integer actionAccountId) {
        this.actionAccountId = actionAccountId;
    }

    public String getFriendshipDate() {
        return friendshipDate;
    }

    public void setFriendshipDate(String friendshipDate) {
        this.friendshipDate = friendshipDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
