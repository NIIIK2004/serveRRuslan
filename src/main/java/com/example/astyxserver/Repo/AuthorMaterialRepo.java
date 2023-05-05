package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.AuthorMaterial;
import com.example.astyxserver.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorMaterialRepo extends JpaRepository<AuthorMaterial, Long> {
    List<AuthorMaterial> findByUser(User user);
}
