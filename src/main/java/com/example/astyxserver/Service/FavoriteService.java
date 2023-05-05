package com.example.astyxserver.Service;

import com.example.astyxserver.Model.Answer;
import com.example.astyxserver.Model.Favorite;
import com.example.astyxserver.Repo.FavoriteRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavoriteService {
    private final FavoriteRepo favoriteRepo;

    public FavoriteService(FavoriteRepo favoriteRepo) {
        this.favoriteRepo = favoriteRepo;
    }

    public void save(Favorite favorite){
        favoriteRepo.save(favorite);
    }

    public List<Favorite> findAll(){
        return favoriteRepo.findAll();
    }

    public Optional<Favorite> getById(Long id){
        return favoriteRepo.findById(id);
    }

    public void delete(Long id){
        this.favoriteRepo.deleteById(id);
    }
}
