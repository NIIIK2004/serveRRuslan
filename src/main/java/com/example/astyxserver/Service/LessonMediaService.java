package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.LessonMedia;
import com.example.astyxserver.Repo.LessonMediaRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LessonMediaService {
    private final LessonMediaRepo lessonMediaRepo;

    public LessonMediaService(LessonMediaRepo lessonMediaRepo) {
        this.lessonMediaRepo = lessonMediaRepo;
    }

    public void save(LessonMedia lessonMedia){
        lessonMediaRepo.save(lessonMedia);
    }

    public List<LessonMedia> findAll(){
        return lessonMediaRepo.findAll();
    }

    public Optional<LessonMedia> getById(Long id){
        return lessonMediaRepo.findById(id);
    }

    public void delete(Long id){
        this.lessonMediaRepo.deleteById(id);
    }
}
