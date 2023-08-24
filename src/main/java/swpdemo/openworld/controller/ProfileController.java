package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.model.Profile;
import swpdemo.openworld.services.servicesimpl.ProfileService;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @GetMapping
    public String profilePage(Model model, HttpSession session){
        Account account = (Account)session.getAttribute("account");
        Profile profile = profileService.GetProfileByAccountId(account.getId());
        model.addAttribute("profile", profile);
        return("profile");
    }

}
