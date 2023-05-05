package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepo extends JpaRepository<Lesson, Long> {
}
