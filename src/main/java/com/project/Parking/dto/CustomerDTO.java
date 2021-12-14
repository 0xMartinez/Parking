package com.project.Parking.dto;


import com.project.Parking.model.Reservation;
import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {


    private String customerId;
    private List<Reservation> reservations;
}
