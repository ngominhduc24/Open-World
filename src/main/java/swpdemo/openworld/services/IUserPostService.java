package swpdemo.openworld.services;

import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.dto.UserPostDTO;

public interface IUserPostService {
    UserPostDTO getPostById(Integer accountId);
}
