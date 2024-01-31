package org.Toy.DTO.Article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.Toy.Domain.Article;

@NoArgsConstructor
@Getter
public class ArticleListResponse {
    private Long id;
    private String title;
    private String content;

    public ArticleListResponse(Article article){
        this.id = article.getArticle_id();
        this.title = article.getTitle();
        this.content = article.getContent_text();
    }
}
