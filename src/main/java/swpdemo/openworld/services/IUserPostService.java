package swpdemo.openworld.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.dto.UserPostDTO;

import java.util.List;

public interface IUserPostService {
    List<UserPostDTO> getPostByAccountId(Integer accountId, int pageNo, int pageSize);


    List<String> getListUrlImg(Integer accountId, Integer limit);
}
