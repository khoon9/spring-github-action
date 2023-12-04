package com.example.springgithubaction.service;

import com.example.springgithubaction.dto.ArticleCommentDto;
import com.example.springgithubaction.dto.ArticleDto;
import com.example.springgithubaction.repository.ArticleCommentRepository;
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
public class ArticleCommentService {

    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> getArticleCommentsByArticle_Id(Long articleId) {
        return articleCommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(ArticleCommentDto::from)
                .collect(Collectors.toList());
    }

    public List<ArticleCommentDto> getArticleComments() {
        return articleCommentRepository
                .findAll()
                .stream()
                .map(ArticleCommentDto::from)
                .collect(Collectors.toList());
    }
}
