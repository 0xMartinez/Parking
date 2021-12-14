package com.project.Parking.dto;

import com.project.Parking.model.ParkingSpace;
import lombok.Data;

@Data
public class ReservationDTO {

    private String parkingSpaceId;
    private String customerId;
    private ParkingSpace parkingSpace;
}
