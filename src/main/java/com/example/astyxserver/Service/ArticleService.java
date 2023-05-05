package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Article;
import com.example.astyxserver.Repo.ArticleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepo articleRepo;

    public ArticleService(ArticleRepo articleRepo) {
        this.articleRepo = articleRepo;
    }

    public void save(Article article){
        articleRepo.save(article);
    }

    public List<Article> findAll(){
        return articleRepo.findAll();
    }

    public Optional<Article> getById(Long id){
        return articleRepo.findById(id);
    }

    public void delete(Long id){
        this.articleRepo.deleteById(id);
    }
}
