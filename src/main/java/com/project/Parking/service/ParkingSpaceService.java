package com.project.Parking.service;

import com.project.Parking.dto.ParkingSpaceDTO;
import com.project.Parking.repository.ParkingSpaceDAO;
import com.project.Parking.repository.ReservationDAO;
import com.project.Parking.exception.ConflictExceptionHandler;
import com.project.Parking.model.ParkingSpace;
import com.project.Parking.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ParkingSpaceService {


    ParkingSpaceDAO parkingSpaceDAO;
    ReservationDAO reservationDAO;


    public ParkingSpace addParkingSpace(ParkingSpace parkingSpace) {

        String prefix;
        String suffix;
        String nr;

        prefix = Integer.toString(parkingSpace.getPlaceNumber());
        suffix = Integer.toString(parkingSpace.getStorey());
        nr = String.join("-",prefix,suffix);
        Optional<ParkingSpace> optionalParkingSpace = parkingSpaceDAO.findById(nr);
        if((optionalParkingSpace.isPresent())) {
            throw new ConflictExceptionHandler("There is already parking space with same number and storey ");
        }

        parkingSpace.setParkingSpaceId(nr);
        return parkingSpaceDAO.save(parkingSpace);
    }

    public List<ParkingSpaceDTO> getFreeParkingSpaces(){

    List<ParkingSpaceDTO> parkingSpaces = new ArrayList<>();
    List<Reservation> reservations = new ArrayList<>();
    List<ParkingSpaceDTO> freeParkingSpaces = new ArrayList<>();
    parkingSpaces.addAll(parkingSpaceDAO.findAll()
            .stream()
            .map(this::convertEntityToDTO)
            .collect(Collectors.toList()));
    reservations.addAll(reservationDAO.findAll());

    if (reservations.isEmpty()) {
        return parkingSpaceDAO.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList()) ;
    }
    freeParkingSpaces.addAll(parkingSpaces);

    for (ParkingSpaceDTO parkingSpace : parkingSpaces) {
        for (Reservation reservation : reservations) {
            if ((parkingSpace.getParkingSpaceId().equals(reservation.getParkingSpaceId()))) {
                freeParkingSpaces.remove(parkingSpace);
            }
        }
    }
    return freeParkingSpaces;
}
    public List<ParkingSpaceDTO> getParkingSpace(){
        return parkingSpaceDAO.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private ParkingSpaceDTO convertEntityToDTO(ParkingSpace parkingSpace){

        ParkingSpaceDTO parkingSpaceDTO = new ParkingSpaceDTO();
        parkingSpaceDTO.setParkingSpaceId(parkingSpace.getParkingSpaceId());
        parkingSpaceDTO.setReservation(parkingSpace.getReservation());
        parkingSpaceDTO.setForDisabled(parkingSpace.isForDisabled());
        parkingSpaceDTO.setStorey(parkingSpace.getStorey());
        parkingSpaceDTO.setPlaceNumber(parkingSpace.getPlaceNumber());
        return parkingSpaceDTO;
    }


}
