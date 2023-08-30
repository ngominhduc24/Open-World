package swpdemo.openworld.services.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import swpdemo.openworld.model.Friendship;
import swpdemo.openworld.model.Profile;
import swpdemo.openworld.repository.IFriendshipRepository;
import swpdemo.openworld.repository.IProfileRepository;
import swpdemo.openworld.services.IFriendshipService;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendshipService implements IFriendshipService {
    @Autowired
    IFriendshipRepository friendshipRepository;

    @Autowired
    IProfileRepository profileRepository;

    @Override
    public List<Profile> getListProfileNameAndAvtFriend(Integer accountId, Integer limit) {
        List<Profile> listProfiles = new ArrayList<>();
        Pageable page = PageRequest.of(0, limit);
        Slice<Friendship> listFriendship = friendshipRepository.getFriendshipByAccountId1OrAccountId2(accountId, accountId, page);
        listFriendship.stream().forEach(friendship -> {
            int accId = friendship.getAccountId1() == accountId.intValue() ? friendship.getAccountId2() : friendship.getAccountId1();
            listProfiles.add(profileRepository.findProfileByAccountId(accId));
        });
        return listProfiles;
    }
}
