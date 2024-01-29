package org.Toy.DTO.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.Toy.Domain.Article;
import org.Toy.Domain.Embedded.CREATE;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ArticleAddRequest {
    private String title;
    private String content_text;
    private CREATE create;

    public Article toEntity(){
        return Article.builder().
                title(title).
                content_text(content_text).
                create(create).
                build();
    }
}
