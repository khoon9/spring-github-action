package com.example.springgithubaction.controller;

import com.example.springgithubaction.dto.ArticleDto;
import com.example.springgithubaction.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class MainController {

    public final ArticleService articleService;

    @GetMapping("/test")
    public String getTestString(){
        return "테스트";
    }

    @GetMapping("/article/{article_id}")
    public ResponseEntity<ArticleDto> getArticle(@PathVariable Long article_id){
        return ResponseEntity.ok(articleService.getArticle(article_id));
    }
    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> getArticles(){
        return ResponseEntity.ok(articleService.getArticles());
    }

    @PutMapping("/article")
    public ResponseEntity<String> putArticles(@RequestBody ArticleDto articleDto){
        return ResponseEntity.ok(articleService.saveArticle(articleDto));
    }

}
