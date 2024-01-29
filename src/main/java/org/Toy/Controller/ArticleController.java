package org.Toy.Controller;

import lombok.RequiredArgsConstructor;
import org.Toy.DTO.Article.ArticleAddRequest;
import org.Toy.Domain.Article;
import org.Toy.Domain.Embedded.CREATE;
import org.Toy.Domain.USER;
import org.Toy.Service.ArticleService;
import org.Toy.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Scanner;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final UserService userService;
    private final ArticleService articleService;
    @PostMapping("/saveArticle")
    public ResponseEntity<Article> saveArticle(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("title : ");
        String title = scanner.next();
        System.out.print("content_text : ");
        String content_text = scanner.next();
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        USER user = userService.findByUser_Id(1L);
        CREATE create = new CREATE(time,user);

        Article article = new Article(title,content_text,create);
        articleService.save(article);
        return ResponseEntity.status(HttpStatus.CREATED).body(article);
    }
    @GetMapping("api/test")
    public String hello(){
        System.out.println("hello");
        return "테스트입니다.";
    }
}
