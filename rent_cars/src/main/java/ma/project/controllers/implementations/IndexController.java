package ma.project.controllers.implementations;

import lombok.AllArgsConstructor;
import ma.project.services.implementations.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class IndexController {
    private ArticleService articleService;

    @GetMapping(path = "/")
    public String indexPage(Model model) {
        int listSize = articleService.findAll().size();
        if (listSize >= 3)
            model.addAttribute("articles", articleService.findAll().subList(listSize - 3, listSize));
        else
            model.addAttribute("articles", articleService.findAll());
        return "index";
    }

    @GetMapping(path = "/dashboard")
    public String dashboardPage(){
        return "admin/index";
    }

}
