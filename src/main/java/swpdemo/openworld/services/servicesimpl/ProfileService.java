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

    public Profile updateProfile(Integer id, Profile profileRequest){
        Profile existingProfile = profileRepository.findProfileByAccountId(id);
        existingProfile.setEmail(profileRequest.getEmail());
        existingProfile.setPhone(profileRequest.getPhone());
        existingProfile.setDob(profileRequest.getDob());
        existingProfile.setAboutMe(profileRequest.getAboutMe());
        existingProfile.setGender(profileRequest.getGender());
        existingProfile.setAvatarUrl(profileRequest.getAvatarUrl());
        existingProfile.setCoverUrl(profileRequest.getCoverUrl());
        existingProfile.setFullName(profileRequest.getFullName());
        return profileRepository.save(existingProfile);
    }
}
