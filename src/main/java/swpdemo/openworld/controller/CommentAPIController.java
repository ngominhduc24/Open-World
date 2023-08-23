package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import swpdemo.openworld.dto.CommentDTO;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.services.servicesimpl.CommentService;
import swpdemo.openworld.services.servicesimpl.UserPostService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CommentAPIController {
    @Autowired
    CommentService commentService;

    /*
     * get all userpost where id of account = accountID with limit number of post     ex: /api/v1/post/61?limit=1
     */
    @GetMapping("/comment/{postId}")
    public List<CommentDTO> getUserPost(
            @PathVariable(name = "postId") Integer postId,
            @RequestParam(name = "start", defaultValue = "1") Integer start,
            @RequestParam(name = "end", defaultValue = "10") Integer end,
            HttpSession session
    )  {
        List<CommentDTO> listComment = commentService.getCommentByPostId(postId, start, end);
        if (listComment != null) {
            return listComment;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
