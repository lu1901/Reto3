package com.reto.reto.controller;

import com.reto.reto.custom.CountClient;
import com.reto.reto.custom.StatusAmount;
import com.reto.reto.entities.Category;
import com.reto.reto.entities.Client;
import com.reto.reto.entities.Reservation;
import com.reto.reto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getCategory(@PathVariable("id") int id){

        return reservationService.getReservation(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody  Reservation r){
        return reservationService.save(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation r){
        return reservationService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationStatus(){
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient(){
        return reservationService.getTopClient();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDateReport(@PathVariable("dateOne") String d1, @PathVariable("dateTwo") String d2){
        return reservationService.getReservatioPeriod(d1,d2);
    }

}