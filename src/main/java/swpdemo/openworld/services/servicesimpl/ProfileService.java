package swpdemo.openworld.services.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swpdemo.openworld.model.Profile;
import swpdemo.openworld.repository.IProfileRepository;
import swpdemo.openworld.services.IProfileService;

@Service
public class ProfileService implements IProfileService {
    @Autowired
    IProfileRepository profileRepository;
    @Override
    public Profile GetProfileByAccountId(Integer accountId) {
        return profileRepository.findProfileByAccountId(accountId);
    }
}
