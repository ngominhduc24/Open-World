package swpdemo.openworld.services.servicesimpl;

import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.dto.UserPostDTO;
import swpdemo.openworld.services.IUserPostService;

@Service
public class UserPostService implements IUserPostService {
    @Override
    public UserPostDTO getPostById(Integer accountId) {
        throw new UnsupportedOperationException();
    }
}
