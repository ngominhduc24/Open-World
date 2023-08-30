package swpdemo.openworld.services;

import swpdemo.openworld.model.Profile;

import java.util.List;

public interface IFriendshipService {
    List<Profile> getListProfileNameAndAvtFriend(Integer accountId, Integer limit);
}
