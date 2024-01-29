package org.Toy.Domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.Toy.Domain.Embedded.CREATE;

@Entity
@Table(name = "article_comment")
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long article_comment_id;
    @Column(nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "article_id")
    private Article article_id;
    @Column(columnDefinition = "int dafault 0")
    private int love;
    @Column(columnDefinition = "int dafault 0")
    private int hate;

    @Embedded
    private CREATE create;
}
