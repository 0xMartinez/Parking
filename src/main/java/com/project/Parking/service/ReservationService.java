package com.project.Parking.service;

import com.project.Parking.dto.ReservationDTO;
import com.project.Parking.repository.CustomerDAO;
import com.project.Parking.repository.ParkingSpaceDAO;
import com.project.Parking.repository.ReservationDAO;
import com.project.Parking.exception.ConflictExceptionHandler;
import com.project.Parking.exception.NotFoundExceptionHandler;
import com.project.Parking.model.Customer;
import com.project.Parking.model.ParkingSpace;
import com.project.Parking.model.Reservation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ReservationService {


    ParkingSpaceDAO parkingSpaceDAO;
    ReservationDAO reservationDAO;
    CustomerDAO customerDAO;

    public Reservation setReservation(Reservation reservation){

        Optional<Customer> optionalCustomer = customerDAO.findById(reservation.getCustomerId());
        Optional<ParkingSpace> optionalParkingSpace = parkingSpaceDAO.findById(reservation.getParkingSpaceId());
        Optional<Reservation> optionalReservation = reservationDAO.findById(reservation.getParkingSpaceId());
        if(optionalCustomer.isEmpty()) {
            throw new NotFoundExceptionHandler("There is no such customer.");
        }
        if(optionalParkingSpace.isEmpty())
        {
            throw new NotFoundExceptionHandler("There is no such parking space.");
        }
        if((optionalReservation.isPresent())) {
            throw new ConflictExceptionHandler("There is reservation for this parking space already.");
        }
        Customer customer = new Customer();
        customer.setCustomerId(reservation.getCustomerId());
        reservation.setCustomer(customer);
        return reservationDAO.save(reservation);
    }
    public void deleteReservation(String id){
        Optional<Reservation> optionalReservation = reservationDAO.findById(id);
        Reservation reservation = new Reservation();
        if(optionalReservation.isEmpty()) {
            throw new NotFoundExceptionHandler("There is no such reservation.");
        }
        reservationDAO.deleteById(id);
    }

    /*
    public List<Reservation> getReservation(String CustomerId)
    {
        Optional<Reservation> optionalReservation = reservationDAO.findById(CustomerId);
        if (!(optionalReservation.isEmpty())) {
            throw new NotFoundExceptionHandler("There is no reservations for such customer");
        }
        return  reservationDAO.findAllByCustomerId(CustomerId);
    }
*/
    public List<ReservationDTO> getReservations(String CustomerId){
        return reservationDAO.findAllByCustomerId(CustomerId)
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private ReservationDTO convertEntityToDTO(Reservation reservation){

        Optional<Reservation> optionalReservation = reservationDAO.findById(reservation.getCustomerId());
        if (!(optionalReservation.isEmpty())) {
            throw new NotFoundExceptionHandler("There is no reservations for such customer");
        }
        reservationDAO.findAllByCustomerId(reservation.getCustomerId());
        ReservationDTO reservationDTO = new ReservationDTO();
        reservationDTO.setParkingSpace(reservation.getParkingSpace());
        reservationDTO.setParkingSpaceId(reservation.getParkingSpaceId());
        reservationDTO.setCustomerId(reservation.getCustomerId());
        return reservationDTO;
    }
}
