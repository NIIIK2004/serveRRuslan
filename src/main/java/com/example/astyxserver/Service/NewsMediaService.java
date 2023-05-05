package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.NewsMedia;
import com.example.astyxserver.Repo.NewsMediaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsMediaService {
    private final NewsMediaRepo newsMediaRepo;

    public NewsMediaService(NewsMediaRepo newsMediaRepo) {
        this.newsMediaRepo = newsMediaRepo;
    }
    public void save(NewsMedia newsMedia){
        newsMediaRepo.save(newsMedia);
    }

    public List<NewsMedia> findAll(){
        return newsMediaRepo.findAll();
    }

    public Optional<NewsMedia> getById(Long id){
        return newsMediaRepo.findById(id);
    }

    public void delete(Long id){
        this.newsMediaRepo.deleteById(id);
    }
}
