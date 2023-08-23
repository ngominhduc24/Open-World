package swpdemo.openworld.services;

import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.UserPostDTO;

import java.util.List;

@Service
public interface ICommentService {
    List<UserPostDTO> getCommentByPostId(Integer accountId, int start, int end);
}
