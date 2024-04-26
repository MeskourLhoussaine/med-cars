package ma.project.controllers.implementations;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotFoundController implements ErrorController {

    @GetMapping(path = "/notFound")
    public String notFoundPage() {
        return "404";
    }
}
