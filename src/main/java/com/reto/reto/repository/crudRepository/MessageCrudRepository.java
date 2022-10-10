package com.reto.reto.repository.crudRepository;


import com.reto.reto.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
