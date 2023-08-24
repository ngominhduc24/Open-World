package swpdemo.openworld.services.servicesimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.CommentDTO;
import swpdemo.openworld.model.Comment;
import swpdemo.openworld.repository.ICommentRepository;
import swpdemo.openworld.repository.IReactRepository;
import swpdemo.openworld.services.ICommentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService implements ICommentService {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    ICommentRepository commentRepository;

    @Autowired
    IReactRepository reactRepository;

    @Override
    public List<CommentDTO> getCommentByPostId(Integer postId, int pageNo, int pageSize) {
        List<CommentDTO> listCommentDTO = new ArrayList<>();
        Pageable page = PageRequest.of(pageNo, pageSize, Sort.by("createAt").descending());
        Slice<Comment> ListComment = commentRepository.findByPostId(postId, page);

        // Convert list Comment to list CommentDTO using the mapper
        ListComment.stream().forEach(comment -> {
            CommentDTO commentDTO = mapper.map(comment, CommentDTO.class);
            Integer commentId = commentDTO.getId();
            commentDTO.setTotalReact(reactRepository.countAllByCommentId(commentId));
            listCommentDTO.add(commentDTO);
        });

        return listCommentDTO;
    }
}
