package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {
}
