package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String loginPage(WebRequest request, Model model, HttpSession session) {
        if(session.getAttribute("account") == null) {
            return "login";
        }
        return "home";
    }
}
