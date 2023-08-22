package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.repository.IAccountRepository;
import swpdemo.openworld.services.servicesimpl.AccountService;

import java.util.List;

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
        session.setAttribute("account", account);
        System.out.println(account);
        return "redirect:/home";
    }
}
