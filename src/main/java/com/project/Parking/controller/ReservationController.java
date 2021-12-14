package com.project.Parking.controller;

import com.project.Parking.dto.ReservationDTO;
import com.project.Parking.model.Reservation;
import com.project.Parking.service.ReservationService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    ReservationService reservationService;

    @ApiOperation(value = "Add reservation", notes = "provide information about reservation")
    @PostMapping(value = "/add")
    public String setReservation(Reservation reservation){
        reservationService.setReservation(reservation);
        return "Reservation added";
    }

    /*
    @ApiOperation(value = "List reservation for provided customer")
    @GetMapping(value = "/list/{CustomerId}")
    public List<Reservation> getReservation(String CustomerId) {
        return reservationService.getReservation(CustomerId);
    }
*/
    @ApiOperation(value = "List reservation for all")
    @GetMapping(value = "/list/{CustomerId}")
    public List<ReservationDTO> getReservations(String CustomerId) {
        return reservationService.getReservations(CustomerId);
    }

    @ApiOperation(value = "This method is used to delete data.", hidden = true)
    @PostMapping(value = "/delete/{ParkingSpaceId}")
    void deleteReservation(String ParkingSpaceId) {
        reservationService.deleteReservation(ParkingSpaceId);
    }
}
