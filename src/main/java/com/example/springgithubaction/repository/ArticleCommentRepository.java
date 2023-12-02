package com.example.springgithubaction.repository;

import com.example.springgithubaction.domain.ArticleComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {

    List<ArticleComment> findByArticle_Id(Long articleId);
}