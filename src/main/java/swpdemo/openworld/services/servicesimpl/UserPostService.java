package swpdemo.openworld.services.servicesimpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import swpdemo.openworld.dto.UserPostDTO;
import swpdemo.openworld.model.UserPost;
import swpdemo.openworld.repository.ICommentRepository;
import swpdemo.openworld.repository.IReactRepository;
import swpdemo.openworld.services.IUserPostService;
import swpdemo.openworld.repository.IUserPostRepository;


import java.util.ArrayList;
import java.util.List;

@Service
public class UserPostService implements IUserPostService {
    @Autowired
    IUserPostRepository UserPostRepository;
    @Autowired
    IReactRepository ReactRepository;
    @Autowired
    ICommentRepository CommentRepository;
    ModelMapper mapper = new ModelMapper();
    @Override
    public List<UserPostDTO> getPostByAccountId(Integer accountId, int pageNo, int pageSize) {
        List<UserPostDTO> ListUserPostDTO = new ArrayList<>();
        List<UserPost> ListUserPost = UserPostRepository.findAllPostsByAccountId(accountId, PageRequest.of(pageNo, pageSize, Sort.by("createAt").descending()));
        // Convert UserPost to UserPostDTO
        ListUserPost.stream().forEach(UserPost -> {
            UserPostDTO UserPostDTO = mapper.map(UserPost, UserPostDTO.class);
            Integer postId = UserPostDTO.getId();
            UserPostDTO.setUserReact(ReactRepository.findUserReact(postId));
            UserPostDTO.setTotalReact(ReactRepository.countAllByPostId(postId));
            UserPostDTO.setTotalComment(CommentRepository.countAllByPostId(postId));
            UserPostDTO.setTotalShare(UserPostRepository.countAllByPostShareId(postId));

            ListUserPostDTO.add(UserPostDTO);
        });
        return ListUserPostDTO;
    }

    @Override
    public List<String> getListUrlImg(Integer accountId, Integer limit) {
        List<String> listImg = UserPostRepository.findListImgByAccountId(accountId, limit);
        return listImg.stream().filter(imgUrl -> imgUrl != null).toList();
    }
}