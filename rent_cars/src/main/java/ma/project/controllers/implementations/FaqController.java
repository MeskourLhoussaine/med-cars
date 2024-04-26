package ma.project.controllers.implementations;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FaqController {

    @GetMapping(path = "/faq")
    public String faqPage() {
        return "faq";
    }
}
