package com.project.Parking.repository;


import com.project.Parking.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReservationDAO extends CrudRepository<Reservation, String> {

    @Override
    List<Reservation> findAll();

    List<Reservation> findAllByCustomerId(String customerId);
}
