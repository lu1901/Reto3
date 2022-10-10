package com.reto.reto.controller;

import com.reto.reto.entities.Game;
import com.reto.reto.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/all")
    public List<Game> getAll(){
        return gameService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Game save(@RequestBody  Game g){
        return gameService.save(g);
    }
}