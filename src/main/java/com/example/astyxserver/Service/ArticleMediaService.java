package com.example.astyxserver.Service;

import com.example.astyxserver.Model.ArticleMedia;
import com.example.astyxserver.Repo.ArticleMediaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleMediaService {
    private final ArticleMediaRepo articleMediaRepo;

    public ArticleMediaService(ArticleMediaRepo articleMediaRepo) {
        this.articleMediaRepo = articleMediaRepo;
    }

    public void save(ArticleMedia articleMedia){
        articleMediaRepo.save(articleMedia);
    }

    public List<ArticleMedia> findAll(){
        return articleMediaRepo.findAll();
    }

    public Optional<ArticleMedia> findById(Long id){
        return articleMediaRepo.findById(id);
    }

    public void delete(Long id){
        this.articleMediaRepo.deleteById(id);
    }
}
