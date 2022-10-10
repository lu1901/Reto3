package com.reto.reto.service;

import com.reto.reto.entities.Game;
import com.reto.reto.repository.GameRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll(){
        return gameRepository.getAll();
    }
    public Optional<Game> getGame(int id){
        return gameRepository.getGame(id);
    }
    public Game save(Game g){
        if(g.getId()==null){
            return gameRepository.save(g);
        }else{
            Optional<Game> e = gameRepository.getGame(g.getId());
            if(e.isPresent()){
                return g;
            }else{
                return gameRepository.save(g);
            }
        }
    }
    public Game update(Game g){
        if(g.getId()!=null){
            Optional<Game> q = gameRepository.getGame(g.getId());
            if(q.isPresent()){
                if(g.getName()!=null){
                    q.get().setName(g.getName());
                }
                if(g.getDeveloper()!=null){
                    q.get().setDeveloper(g.getDeveloper());
                }
                if(g.getYear()!=null){
                    q.get().setYear(g.getYear());
                }
                if(g.getDescription()!=null){
                    q.get().setDescription(g.getDescription());
                }
                if(g.getCategory()!=null){
                    q.get().setCategory(g.getCategory());
                }
                if(g.getMessages()!=null){
                    q.get().setMessages(g.getMessages());
                }
                if(g.getReservations()!=null){
                    q.get().setReservations(g.getReservations());
                }
                gameRepository.save(q.get());
                return q.get();
            }else{
                return g;
            }
        }else{
            return g;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Game>g= gameRepository.getGame(id);
        if(g.isPresent()){
            gameRepository.delete(g.get());
            flag=true;
        }
        return flag;

    }


}