package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String loginPage(WebRequest request, Model model, HttpSession session) {
        session.removeAttribute("account");
        return "login";
    }
}
