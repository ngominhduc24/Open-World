package swpdemo.openworld.services.servicesimpl;

import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.CommentDTO;
import swpdemo.openworld.services.ICommentService;

import java.util.List;

@Service
public class CommentService implements ICommentService {
    @Override
    public List<CommentDTO> getCommentByPostId(Integer postId, int start, int end) {
        return null;
    }
}
