package swpdemo.openworld.services;

import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.dto.UserPostDTO;

import java.util.List;

public interface IUserPostService {
    List<UserPostDTO> getPostById(Integer accountId, int limit);
}
