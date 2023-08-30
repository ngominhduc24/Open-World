package swpdemo.openworld.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import swpdemo.openworld.dto.AccountDTO;
import swpdemo.openworld.model.Account;
import swpdemo.openworld.services.servicesimpl.AccountService;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Controller
public class RegisterController {
    @Autowired
    AccountService accountService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        AccountDTO accountDTO = (AccountDTO) model.getAttribute("AccountDTO");
        if (accountDTO == null) {
            model.addAttribute("AccountDTO", new AccountDTO());
        } else {
            model.addAttribute("AccountDTO", accountDTO);
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerAccount(WebRequest request, Model model, HttpSession session, @ModelAttribute AccountDTO accountDTO, BindingResult bindingResult) {

        // check if blind error
        if (bindingResult.hasErrors()) {
            model.addAttribute("AccountDTO", accountDTO);
            session.setAttribute("errmsg", "All field are required");
            return "register";

        } else {
            // check if blank
            if (accountDTO.getFullName() == null || accountDTO.getFullName().isEmpty()
                    || accountDTO.getUsername() == null || accountDTO.getUsername().isEmpty()
                    || accountDTO.getPassword() == null || accountDTO.getPassword().isEmpty()
                    || accountDTO.getDob() == null
                    || accountDTO.getGender() == null
            ) {
                model.addAttribute("AccountDTO", accountDTO);
                session.setAttribute("errmsg", "All field are required");
                return "register";

            }

            String re_password = request.getParameter("re-password");
            if (re_password == null || re_password.isEmpty()) {
                model.addAttribute("AccountDTO", accountDTO);
                session.setAttribute("errmsg", "All field are required");
                return "register";

            }

            //check pass's length
            if (accountDTO.getPassword().length() < 6 || accountDTO.getPassword().length() > 32) {
                model.addAttribute("AccountDTO", accountDTO);
                session.setAttribute("errmsg", "Password is only from 6 to 32 characters");
                return "register";

            }

            //check valid date ( before now, at least 12 y-o)
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date dob = null;
            try {
                dob = sdf.parse(accountDTO.getDob().toString());
            } catch (ParseException e) {
                model.addAttribute("AccountDTO", accountDTO);
                session.setAttribute("errmsg", "Invalid birthday");
                return "register";

            }
            java.util.Date currentDate = new java.util.Date();
            java.util.Date minAgeDate = new java.util.Date(currentDate.getTime() - 12L * 365 * 24 * 60 * 60 * 1000);

            if (!(dob.before(currentDate) && dob.before(minAgeDate))) {
                model.addAttribute("AccountDTO", accountDTO);
                session.setAttribute("errmsg", "Invalid birthday");
                return "register";

            }

            // check if pass == re_pass
            if (!re_password.equals(accountDTO.getPassword())) {
                model.addAttribute("AccountDTO", accountDTO);
                session.setAttribute("errmsg", "password and re-password is not correct");
                return "register";

            } else {
                Account account = accountService.registerNewAccount(accountDTO);
                if (accountDTO != null) {
                    session.setAttribute("account", account);
                    return "redirect:/home";
                }
            }
        }

        return "register";
    }
}
