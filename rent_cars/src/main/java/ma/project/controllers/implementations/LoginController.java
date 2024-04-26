package ma.project.controllers.implementations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping(path = "/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping(path = "/register")
    public String registerPage(){
        return "register";
    }
}
