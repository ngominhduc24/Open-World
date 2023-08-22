package swpdemo.openworld;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todo")
public class toDoList {
    @GetMapping
    public String start(Model model){
        model.addAttribute("item","list num 1");
        return "/todo";
    }

    @DeleteMapping(path = "/delete", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    public String delete(){
        return "";
    }

    @PostMapping(path = "/create")
    public String create(@RequestParam("new-todo") String todo, Model model) {
        model.addAttribute("item", todo);
        return "todo :: todo";
    }
}
