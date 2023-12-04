package com.example.springgithubaction.dto;

import com.example.springgithubaction.domain.Article;


public record ArticleDto(
        Long id,
        String title,
        String content,
        String hashtag
) {

    public static ArticleDto of(String title, String content, String hashtag) {
        return new ArticleDto(null, title, content, hashtag);
    }

    public static ArticleDto of(Long id, String title, String content, String hashtag) {
        return new ArticleDto(id, title, content, hashtag);
    }

    public static ArticleDto from(Article entity) {
        return new ArticleDto(
                entity.getId(),
                entity.getTitle(),
                entity.getContent(),
                entity.getHashtag()
        );
    }

    public Article toEntity() {
        return Article.of(
                title,
                content,
                hashtag
        );
    }

}
