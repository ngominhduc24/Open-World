package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.services.servicesimpl.AccountService;

@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("AccountDTO", new AccountDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(WebRequest request, Model model, HttpSession session, @ModelAttribute AccountDTO accountDTO) {
        String re_password = request.getParameter("re-password");
        if(!re_password.equals(accountDTO.getPassword())) {
            session.setAttribute("errmsg", "password and re-password is not correct");
            return "redirect:/register";
        }
        else {
            Account account = accountService.registerNewAccount(accountDTO);
            if(accountDTO != null) {
                session.setAttribute("account", account);
                return "home";
            }
        }
        return "register";
    }
}
