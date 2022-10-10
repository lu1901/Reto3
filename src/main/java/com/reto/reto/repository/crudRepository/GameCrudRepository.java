package com.reto.reto.repository.crudRepository;

import com.reto.reto.entities.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameCrudRepository extends CrudRepository<Game,Integer> {
}
