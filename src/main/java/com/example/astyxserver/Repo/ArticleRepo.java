package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepo extends JpaRepository<Article, Long> {
}
