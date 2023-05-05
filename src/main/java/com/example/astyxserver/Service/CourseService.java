package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Course;
import com.example.astyxserver.Repo.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseRepo courseRepo;

    public CourseService(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void save(Course course){
        courseRepo.save(course);
    }

    public List<Course> findAll(){
        return courseRepo.findAll();
    }

    public Optional<Course> getById(Long id){
        return courseRepo.findById(id);
    }

    public void delete(Long id){
        this.courseRepo.deleteById(id);
    }
}
