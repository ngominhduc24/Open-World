package swpdemo.openworld.services;

import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.CommentDTO;
import swpdemo.openworld.dto.UserPostDTO;

import java.util.List;

public interface ICommentService {
    List<CommentDTO> getCommentByPostId(Integer postId, int start, int end);
}
