package org.Toy.Controller;

import lombok.RequiredArgsConstructor;
import org.Toy.DTO.Article.ArticleListResponse;
import org.Toy.Domain.Article;
import org.Toy.Domain.Embedded.CREATE;
import org.Toy.Domain.USER;
import org.Toy.Service.ArticleService;
import org.Toy.Service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final UserService userService;
    private final ArticleService articleService;
    @PostMapping("/saveArticle")
    public void saveArticle(){
        for(int i=1;i<500; i++) {
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            StringBuilder sb = new StringBuilder();
            Random random = new Random();
            int length = 8;

            for (int j = 0; j < length; j++) {
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                sb.append(randomChar);
            }
            String title = sb.toString();
            int length2 = 100;
            sb = new StringBuilder();
            for (int j = 0; j < length2; j++) {
                int index = random.nextInt(alphabet.length());
                char randomChar = alphabet.charAt(index);
                sb.append(randomChar);
            }
            String content_text = sb.toString();
            LocalDateTime time = LocalDateTime.now();
            System.out.println(time);
            Long randomNum = random.nextLong(51) + 1;
            USER user = userService.findByUser_Id(randomNum);
            CREATE create = new CREATE(time, user);

            Article article = new Article(title, content_text, create);
            articleService.save(article);
        }
        return ;
    }
    @GetMapping("api/test")
    public String hello() {
        System.out.println("hello");
        return "테스트입니다.";
    }
//    @GetMapping("/api/ArticleList")
//    public List<ArticleListResponse> getArticleList(){
//        List<ArticleListResponse> articles = articleService.findAll().stream()
//                .map(ArticleListResponse::new)
//                .toList();
//
//        return articles;
//    }
//    @GetMapping("/api/ArticlePage")
//    public List<ArticleListResponse> getArticlePage(){
//        Pageable page = PageRequest.of(0, 10);
//        List<ArticleListResponse> articles = articleService.findAllByPage(page).stream()
//                .map(ArticleListResponse::new)
//                .toList();
//
//        return articles;
//    }
    @GetMapping("/api/ArticlePage/{page}")
    public List<ArticleListResponse> getArticlePages(@PathVariable int page){
        System.out.println("PRINT");
        Pageable pageRange = PageRequest.of(page, 10);
        List<ArticleListResponse> articles = articleService.findAllByPage(pageRange).stream()
                .map(ArticleListResponse::new)
                .toList();

        return articles;
    }
    @GetMapping("/api/startPage")
    public Long getCountArticle(){
        return articleService.countArticles();
    }
}
