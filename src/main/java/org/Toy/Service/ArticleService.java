package org.Toy.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.Toy.DTO.Article.ArticleAddRequest;
import org.Toy.Domain.Article;
import org.Toy.Repository.ArticleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public void save(Article article){
        articleRepository.save(article);
    }
}
