package com.reto.reto.repository.crudRepository;

import com.reto.reto.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
}
