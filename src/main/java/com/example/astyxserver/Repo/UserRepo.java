package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.AuthorMaterial;
import com.example.astyxserver.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByActivationCode(String code);
    User findByUsername(String username);

    User findByAuthorMaterials(List<AuthorMaterial> authorMaterialList);
}
