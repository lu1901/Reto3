package com.reto.reto.service;

import com.reto.reto.entities.Category;
import com.reto.reto.entities.Score;
import com.reto.reto.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){

        return scoreRepository.getAll();
    }
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    public Score save(Score s){
        if(s.getId()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> e = scoreRepository.getScore(s.getId());
            if(e.isPresent()){
                return s;
            }else{
                return scoreRepository.save(s);
            }
        }
    }
    public Score update(Score s){
        if(s.getId()!=null){
            Optional<Score> q = scoreRepository.getScore(s.getId());
            if(q.isPresent()){
                if(s.getName()!=null){
                    q.get().setName(s.getName());
                }
                if(s.getDescription()!=null){
                    q.get().setDescription(s.getDescription());
                }
                if(s.getReservations()!=null){
                    q.get().setReservations(s.getReservations());
                }
                scoreRepository.save(q.get());
                return q.get();
            }else{
                return s;
            }
        }else{
            return s;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Score>s= scoreRepository.getScore(id);
        if(s.isPresent()){
            scoreRepository.delete(s.get());
            flag=true;
        }
        return flag;

    }


}