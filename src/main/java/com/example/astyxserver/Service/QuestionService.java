package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.Question;
import com.example.astyxserver.Repo.QuestionRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    private final QuestionRepo questionRepo;

    public QuestionService(QuestionRepo questionRepo) {
        this.questionRepo = questionRepo;
    }

    public void save(Question question){
        questionRepo.save(question);
    }

    public List<Question> findAll(){
        return questionRepo.findAll();
    }

    public Optional<Question> getById(Long id){
        return questionRepo.findById(id);
    }

    public void delete(Long id){
        this.questionRepo.deleteById(id);
    }
}
