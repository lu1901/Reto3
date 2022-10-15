package com.reto.reto.service;

import com.reto.reto.entities.Client;
import com.reto.reto.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> e = clientRepository.getClient(c.getIdClient());
            if(e.isPresent()){
                return c;
            }else{
                return clientRepository.save(c);
            }
        }
    }
    public Client update(Client c){
        if(c.getIdClient()!=null){
            Optional<Client> q = clientRepository.getClient(c.getIdClient());
            if(q.isPresent()){
                if(c.getEmail()!=null){
                    q.get().setEmail(c.getEmail());
                }
                if(c.getPassword()!=null){
                    q.get().setPassword(c.getPassword());
                }
                if(c.getName()!=null){
                    q.get().setName(c.getName());
                }
                if(c.getAge()!=null){
                    q.get().setAge(c.getAge());
                }
                clientRepository.save(q.get());
                return q.get();
            }else{
                return c;
            }
        }else{
            return c;
        }
    }
    public boolean delete(int id){
        Boolean d = getClient(id).map(c -> {
            clientRepository.delete(c);
            return true;
        }).orElse(false);
        return d;
    }


}