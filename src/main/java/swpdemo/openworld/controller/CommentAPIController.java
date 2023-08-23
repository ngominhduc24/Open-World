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

public class CommentAPIController {
    @Autowired
    UserPostService userPostService;

    /*
     * get all userpost where id of account = accountID with limit number of post     ex: /api/v1/post/61?limit=1
     */
    @GetMapping("/comment/{postId}")
    public List<UserPostDTO> getUserPost(
            @PathVariable(name = "accountId") Integer accountId,
            @RequestParam(name = "start", defaultValue = "1") Integer start,
            @RequestParam(name = "end", defaultValue = "10") Integer end,
            HttpSession session
    ) throws IllegalAccessException {
        return null;
    }
}
