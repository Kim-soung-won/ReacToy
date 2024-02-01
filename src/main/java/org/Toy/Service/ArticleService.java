package org.Toy.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.Toy.DTO.Article.ArticleAddRequest;
import org.Toy.Domain.Article;
import org.Toy.Repository.ArticleRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public void save(Article article){
        articleRepository.save(article);
    }

    public List<Article> findAll(){
        return articleRepository.findAll();
    }
    public List<Article> findAllByPage(Pageable page){
        return articleRepository.findAllByPage(page).orElseThrow(()->new IllegalArgumentException("해당 페이지에 게시글이 없습니다."));
    }
    public Long countArticles(){
        return articleRepository.countArticles().orElseThrow(()->new IllegalArgumentException("개수를 찾지 못했습니다."));
    }
}
