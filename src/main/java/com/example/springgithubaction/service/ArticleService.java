package com.example.springgithubaction.service;

import com.example.springgithubaction.dto.ArticleDto;
import com.example.springgithubaction.repository.ArticleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public ArticleDto getArticle(Long articleId) {
        return articleRepository.findById(articleId)
                .map(ArticleDto::from)
                .orElseThrow(() -> new EntityNotFoundException("게시글이 없습니다 - articleId: " + articleId));
    }
    @Transactional(readOnly = true)
    public List<ArticleDto> getArticles() {
        return articleRepository.findAll()
                .stream()
                .map(article -> ArticleDto.from(article))
                .collect(Collectors.toList());
    }

    public String saveArticle(ArticleDto dto) {
        articleRepository.save(dto.toEntity());
        return "성공";
    }

}
