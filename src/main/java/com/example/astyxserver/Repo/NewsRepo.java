package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepo extends JpaRepository<News, Long> {
}
