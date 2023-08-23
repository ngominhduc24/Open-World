package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import swpdemo.openworld.dto.UserPostDTO;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.services.servicesimpl.UserPostService;

@RestController
@RequestMapping("/api/v1")
public class UserPostAPIController {
    @Autowired
    UserPostService userPostService;

    /*
     * get all userpost where id of account = accountID
     */
    @GetMapping("/post/{accountId}")
    public UserPostDTO getUserPost(@PathVariable(name = "accountId") Integer accountId, HttpSession session) throws IllegalAccessException {
        // check Authentication
        Account acc = (Account)session.getAttribute("account");
        if(acc.getId() != accountId) {
            throw new IllegalAccessException();
        }

        UserPostDTO userPostDTO = userPostService.getPostById(accountId);
        if (userPostDTO != null) {
            return userPostDTO;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
}
