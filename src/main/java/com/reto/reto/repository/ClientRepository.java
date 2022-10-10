package com.reto.reto.repository;

import com.reto.reto.entities.Client;
import com.reto.reto.repository.crudRepository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    public List<Client> getAll(){

        return (List<Client>) clientCrudRepository.findAll();
    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client C){

        return clientCrudRepository.save(C);
    }

    public void delete(Client c){

        clientCrudRepository.delete(c);
    }
}
