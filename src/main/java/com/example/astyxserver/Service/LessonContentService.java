package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.LessonContent;
import com.example.astyxserver.Repo.LessonContentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonContentService {

    private final LessonContentRepo lessonContentRepo;

    public LessonContentService(LessonContentRepo lessonContentRepo) {
        this.lessonContentRepo = lessonContentRepo;
    }

    public void save(LessonContent lessonContent){
        lessonContentRepo.save(lessonContent);
    }

    public List<LessonContent> findAll(){
        return lessonContentRepo.findAll();
    }

    public Optional<LessonContent> getById(Long id){
        return lessonContentRepo.findById(id);
    }

    public void delete(Long id){
        this.lessonContentRepo.deleteById(id);
    }
}
