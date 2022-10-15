package com.reto.reto.controller;

import com.reto.reto.entities.Category;
import com.reto.reto.entities.Client;
import com.reto.reto.entities.Game;
import com.reto.reto.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/all")
    public List<Game> getAll(){
        return gameService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Game> getGame(@PathVariable("id") int id){

        return gameService.getGame(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody  Game g){
        return gameService.save(g);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Game update(@RequestBody Game g){
        return gameService.update(g);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return gameService.delete(id);
    }

}