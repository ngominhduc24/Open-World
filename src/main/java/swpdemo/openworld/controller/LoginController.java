package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.model.Profile;
import swpdemo.openworld.services.servicesimpl.AccountService;
import swpdemo.openworld.util.GooglePojo;
import swpdemo.openworld.util.GoogleUtils;

import java.io.IOException;
import java.util.Date;

@Controller
public class LoginController {
    @Autowired
    AccountService accountService;

    @GetMapping("/login")
    public String loginPage(WebRequest request, Model model) {
        return "login";
    }

    @PostMapping ("/login")
    public String userLogin(WebRequest request, Model model, HttpSession session) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Account account = accountService.getAccountByUsernameAndPassword(username, password);
        if(account != null) {
            session.setAttribute("account", account);
            return "redirect:/home";
        }
        else {
            model.addAttribute("errmsg", "username or password is not correct");
            return "login";
        }
    }

    @GetMapping ("/login-google")
    public String userLoginGoogle(WebRequest request, Model model, HttpSession session) throws IOException {
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            return "redirect:/login";
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
            Account account = accountService.getAccountByUsernameAndPassword(googlePojo.getEmail(), googlePojo.getId());
            if(account==null) {
                Account newAcc = accountService.registerAccount(googlePojo);
                session.setAttribute("account", newAcc);
                return "redirect:/home";
            } else{
                session.setAttribute("account", account);
                return "redirect:/home";
            }

        }
    }


}
