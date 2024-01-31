package org.Toy.Domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.Toy.Domain.Embedded.CREATE;

@Entity
@Table(name = "article")
@Getter
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content_text;
    @Column
    private int love;
    @Embedded
    private CREATE create;

    @Builder
    public Article(String title, String content_text, CREATE create){
        this.title = title;
        this.content_text = content_text;
        this.create =create;
    }
}
