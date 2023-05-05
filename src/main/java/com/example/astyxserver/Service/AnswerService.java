package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Repo.AnswerRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepo answerRepo;

    public AnswerService(AnswerRepo answerRepo) {
        this.answerRepo = answerRepo;
    }

    public void save(Answer answer){
        answerRepo.save(answer);
    }

    public List<Answer> findAll(){
        return answerRepo.findAll();
    }

    public Optional<Answer> getById(Long id){
        return answerRepo.findById(id);
    }

    public void delete(Long id){
        this.answerRepo.deleteById(id);
    }
}
