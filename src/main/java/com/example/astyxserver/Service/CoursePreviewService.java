package com.example.astyxserver.Service;

import com.example.astyxserver.Model.AuthorMaterial;
import com.example.astyxserver.Model.CoursePreview;
import com.example.astyxserver.Repo.CoursePreviewRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoursePreviewService {
    private final CoursePreviewRepo coursePreviewRepo;

    public CoursePreviewService(CoursePreviewRepo coursePreviewRepo) {
        this.coursePreviewRepo = coursePreviewRepo;
    }

    public void save(CoursePreview coursePreview){
        coursePreviewRepo.save(coursePreview);
    }

    public List<CoursePreview> findAll(){
        return coursePreviewRepo.findAll();
    }

    public Optional<CoursePreview> getById(Long id){
        return coursePreviewRepo.findById(id);
    }

    public void delete(Long id){
        this.coursePreviewRepo.deleteById(id);
    }
}
