package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swpdemo.openworld.dto.UserPostDTO;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.services.servicesimpl.UserPostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserPostAPIController {
    @Autowired
    UserPostService userPostService;

    /*
     * get all userpost where id of account = accountID with limit number of post     ex: /api/v1/post/61?limit=1
     */
    @GetMapping("/post/{accountId}")
    public List<UserPostDTO> getUserPost(
            @PathVariable(name = "accountId") Integer accountId,
            @RequestParam(name = "pageNo", defaultValue = "1") Integer start,
            @RequestParam(name = "pageSize", defaultValue = "10") Integer end,
            HttpSession session
    ) throws IllegalAccessException {
        try {
            Account acc = (Account) session.getAttribute("account");
            if (acc.getId() != accountId) {
                throw new Exception(); // This might need more specific exception handling
            }
        } catch (Exception e) {
            throw new IllegalAccessException();
        }

        List<UserPostDTO> listUserPost = userPostService.getPostByAccountId(accountId, start, end);
        if (listUserPost != null) {
            return listUserPost;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
