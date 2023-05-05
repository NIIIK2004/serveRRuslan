package com.example.astyxserver.Service;

import com.example.astyxserver.Model.AuthorMaterial;
import com.example.astyxserver.Model.User;
import com.example.astyxserver.Repo.AuthorMaterialRepo;
import com.example.astyxserver.Repo.UserRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorMaterialService {

    private final AuthorMaterialRepo authorMaterialRepo;
    private final UserRepo userRepo;

    public AuthorMaterialService(AuthorMaterialRepo authorMaterialRepo, UserRepo userRepo) {
        this.authorMaterialRepo = authorMaterialRepo;
        this.userRepo = userRepo;
    }

    public void save(AuthorMaterial authorMaterial) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepo.findByUsername(username);
        authorMaterial.setUser(user);
        authorMaterial.setCourse(null);
        authorMaterial.setTest(null);
        user.getAuthorMaterials().add(authorMaterial);
        authorMaterialRepo.save(authorMaterial);
    }

    public List<AuthorMaterial> findByUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepo.findByUsername(username);
        return authorMaterialRepo.findByUser(user);
    }

    public List<AuthorMaterial> findAll(){
        return authorMaterialRepo.findAll();
    }

    public Optional<AuthorMaterial> getById(Long id){
        return authorMaterialRepo.findById(id);
    }

    public void delete(Long id){
        this.authorMaterialRepo.deleteById(id);
    }
}
