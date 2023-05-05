package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Lesson;
import com.example.astyxserver.Repo.LessonRepo;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LessonService {
    private final LessonRepo lessonRepo;

    public LessonService(LessonRepo lessonRepo) {
        this.lessonRepo = lessonRepo;
    }

    public void save(Lesson lesson){
        lessonRepo.save(lesson);
    }

    public List<Lesson> findAll(){
        return lessonRepo.findAll();
    }

    public Optional<Lesson> getById(Long id){
        return lessonRepo.findById(id);
    }

    public void delete(Long id){
        this.lessonRepo.deleteById(id);
    }
}
