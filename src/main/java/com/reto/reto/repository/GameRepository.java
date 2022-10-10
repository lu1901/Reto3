package com.reto.reto.repository;

import com.reto.reto.entities.Game;
import com.reto.reto.repository.crudRepository.GameCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class GameRepository {

    @Autowired
    private GameCrudRepository gameCrudRepository;

    public List<Game> getAll(){

        return (List<Game>) gameCrudRepository.findAll();
    }

    public Optional<Game> getGame(int id){
        return gameCrudRepository.findById(id);
    }

    public Game save(Game g){

        return gameCrudRepository.save(g);
    }

    public void delete(Game g){

        gameCrudRepository.delete(g);
    }
}
