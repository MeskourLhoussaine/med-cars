package ma.project.controllers.implementations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicesController {

    @GetMapping(path = "/services")
    public String ServicesPage(){
        return "services";
    }
}
