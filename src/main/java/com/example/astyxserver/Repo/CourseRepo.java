package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Long> {
}
