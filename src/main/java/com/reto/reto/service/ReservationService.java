package com.reto.reto.service;

import com.reto.reto.custom.CountClient;
import com.reto.reto.custom.StatusAmount;
import com.reto.reto.entities.Reservation;
import com.reto.reto.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){

        return reservationRepository.getAll();
    }
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation r){
        if(r.getIdReservation()==null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservation> e = reservationRepository.getReservation(r.getIdReservation());
            if(e.isPresent()){
                return r;
            }else{
                return reservationRepository.save(r);
            }
        }
    }
    public Reservation update(Reservation r){
        if(r.getIdReservation()!=null){
            Optional<Reservation> q = reservationRepository.getReservation(r.getIdReservation());
            if(q.isPresent()){
                if(r.getStartDate()!=null){
                    q.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null){
                    q.get().setDevolutionDate(r.getDevolutionDate());
                }
                if(r.getStatus()!=null){
                    q.get().setStatus(r.getStatus());
                }
                reservationRepository.save(q.get());
                return q.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean delete(int id){
        Boolean d = getReservation(id).map(r -> {
            reservationRepository.delete(r);
            return true;
        }).orElse(false);
        return d;
    }
    public List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }
    public StatusAmount getStatusReport(){
        List<Reservation> completed= reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled= reservationRepository.getReservationByStatus("cancelled");

        StatusAmount desAmt = new StatusAmount(completed.size(), cancelled.size());
        return desAmt;
    }
    public List<Reservation> getReservatioPeriod(String d1, String d2){

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne = new Date();
        Date dateTwo = new Date();

        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);

        }catch (ParseException e){
            e.printStackTrace();
        }

        if (dateOne.before(dateTwo)){
            return reservationRepository.getReservationPeriod(dateOne, dateTwo);
        }else {
            return new ArrayList<>();
        }
    }

}