package ma.project.services.implementations;

import ma.project.Repositories.implemantations.ArticleRepository;
import ma.project.models.implemantations.Article;
import ma.project.services.GenericService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ArticleService extends GenericService<Article> {
    public ArticleService(ArticleRepository articleRepository) {
        super(articleRepository);
    }
}
