package com.project.Parking.dto;

import com.project.Parking.model.Reservation;
import lombok.Data;

@Data
public class ParkingSpaceDTO {

    private String parkingSpaceId;
    private int placeNumber;
    private int storey;
    private boolean forDisabled;
    private Reservation reservation;
}
