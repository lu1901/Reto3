package com.reto.reto.repository;

import com.reto.reto.custom.CountClient;
import com.reto.reto.entities.Client;
import com.reto.reto.entities.Reservation;
import com.reto.reto.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation r){
        return reservationCrudRepository.save(r);
    }

    public void delete(Reservation r){
        reservationCrudRepository.delete(r);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i=0; i<report.size();i++){
             /*
            Client cli= (Client) report.get(i)[0];
            Long cantidad = (Long) report.get(i)[1];
            CountClient cc= new CountClient(cantidad,cli);
            res.add(cc); */
        res.add(new CountClient((Long) report.get(i)[1], (Client) report.get(i)[0]));
        }

        return res;
    }

}
