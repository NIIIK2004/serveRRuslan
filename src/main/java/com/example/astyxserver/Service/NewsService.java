package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.News;
import com.example.astyxserver.Repo.NewsRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    private final NewsRepo newsRepo;

    public NewsService(NewsRepo newsRepo) {
        this.newsRepo = newsRepo;
    }

    public void save(News news){
        newsRepo.save(news);
    }

    public List<News> findAll(){
        return newsRepo.findAll();
    }

    public Optional<News> getById(Long id){
        return newsRepo.findById(id);
    }

    public void delete(Long id){
        this.newsRepo.deleteById(id);
    }
}
