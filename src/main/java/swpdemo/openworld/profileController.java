package swpdemo.openworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class profileController {
    @GetMapping
    public String profileView(Model model){
        return("profile");
    }
}
