package swpdemo.openworld.services;

import swpdemo.openworld.model.Profile;

public interface IProfileService {
    Profile GetProfileByAccountId(Integer accountId);
}
