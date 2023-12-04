package com.example.springgithubaction.repository;

import com.example.springgithubaction.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}