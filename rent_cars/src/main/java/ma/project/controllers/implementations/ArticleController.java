package ma.project.controllers.implementations;

import lombok.AllArgsConstructor;
import ma.project.models.implemantations.Article;
import ma.project.services.implementations.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Controller
@Transactional
@AllArgsConstructor
public class ArticleController {
    private ArticleService articleService;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/src/main/resources/static/uploads/blog/";


    @GetMapping(path = "/article")
    public String articlePage(Model model) {
        model.addAttribute("articles", articleService.findAll());
        return "article";
    }

    @GetMapping(path = "/article/{id}/details")
    public String articleDetailsPage(@PathVariable Long id, Model model) {
        int listSize = articleService.findAll().size();
        model.addAttribute("articleDetails", articleService.findById(id));
        if (listSize >= 4)
            model.addAttribute("articles", articleService.findAll().subList(listSize - 5, listSize));
        else
            model.addAttribute("articles", articleService.findAll());
        return "article-details";
    }

    @GetMapping(path = "/dashboard/articles")
    public String dashboardArticlePage(Model model) {
        model.addAttribute("articles", articleService.findAll());
        model.addAttribute("article", new Article());
        return "admin/article";
    }

    @PostMapping(path = "/dashboard/articles/save")
    public String dashboardArticlePost(@RequestParam(value = "title") String title,
                                       @RequestParam(value = "content") String content,
                                       @RequestParam(value = "image") MultipartFile multipartFile) {
        try {
            String fileName = multipartFile.getOriginalFilename();
            assert fileName != null;
            String imageName = "bolg_" + new Date().toString().replace(" ", "_")
                    .replace(":", "_") + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
            Path path = Paths.get(UPLOAD_DIRECTORY + imageName);
            Files.write(path, multipartFile.getBytes());

            Article article = new Article();
            article.setTitle(title);
            article.setContent(content);
            article.setImage("/static/uploads/blog/" + imageName);
            articleService.save(article);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/dashboard/articles";
    }
}
