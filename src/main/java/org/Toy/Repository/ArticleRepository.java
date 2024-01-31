package org.Toy.Repository;

import org.Toy.Domain.Article;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    @Query(value = "select * from article order by article_id DESC", nativeQuery = true)
    Optional<List<Article>> findAllByPage(Pageable pageable);
}
