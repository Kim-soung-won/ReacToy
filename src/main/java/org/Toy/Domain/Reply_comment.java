package org.Toy.Domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.Toy.Domain.Embedded.CREATE;

@Entity
@Table(name = "reply_comment")
@NoArgsConstructor
public class Reply_comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reply_comment_id;
    @Column(nullable = false)
    private String content;
    @ManyToOne
    @JoinColumn(name = "article_comment_id", referencedColumnName = "article_comment_id")
    private Comment comment_id;
    @Column(columnDefinition = "int default 0")
    private int love;
    @Column(columnDefinition = "int default 0")
    private int hate;

    @Embedded
    private CREATE create;
}
