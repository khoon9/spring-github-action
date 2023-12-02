package com.example.springgithubaction.dto;

import com.example.springgithubaction.domain.Article;
import com.example.springgithubaction.domain.ArticleComment;

import java.time.LocalDateTime;

public record ArticleCommentDto(
        Long id,
        Long articleId,
        String content
) {
    public static ArticleCommentDto of(Long id, Long articleId, String content) {
        return new ArticleCommentDto(id, articleId, content);
    }

    public static ArticleCommentDto from(ArticleComment entity) {
        return new ArticleCommentDto(
                entity.getId(),
                entity.getArticle().getId(),
                entity.getContent()
        );
    }

    public ArticleComment toEntity(Article entity) {
        return ArticleComment.of(
                entity,
                content
        );
    }

}
