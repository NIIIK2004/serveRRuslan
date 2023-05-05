package com.example.astyxserver.Repo;

import com.example.astyxserver.Model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepo extends JpaRepository<Favorite, Long> {
}
