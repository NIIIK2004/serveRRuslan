package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {
}
