package swpdemo.openworld.services.servicesimpl;

import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.dto.UserPostDTO;
import swpdemo.openworld.services.IUserPostService;

import java.util.List;

@Service
public class UserPostService implements IUserPostService {
    @Override
    public List<UserPostDTO> getPostById(Integer accountId, int limit) {
        throw new UnsupportedOperationException();
    }
}
