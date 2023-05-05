package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.Progress;
import com.example.astyxserver.Repo.ProgressRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgressService {
    private final ProgressRepo progressRepo;

    public ProgressService(ProgressRepo progressRepo) {
        this.progressRepo = progressRepo;
    }

    public void save(Progress progress){
        progressRepo.save(progress);
    }

    public List<Progress> findAll(){
        return progressRepo.findAll();
    }

    public Optional<Progress> getById(Long id){
        return progressRepo.findById(id);
    }

    public void delete(Long id){
        this.progressRepo.deleteById(id);
    }
}
