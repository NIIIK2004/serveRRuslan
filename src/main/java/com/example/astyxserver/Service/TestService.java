package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.Test;
import com.example.astyxserver.Repo.TestRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    private final TestRepo testRepo;

    public TestService(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    public void save(Test test){
        testRepo.save(test);
    }

    public List<Test> findAll(){
        return testRepo.findAll();
    }

    public Optional<Test> getById(Long id){
        return testRepo.findById(id);
    }

    public void delete(Long id){
        this.testRepo.deleteById(id);
    }
}
