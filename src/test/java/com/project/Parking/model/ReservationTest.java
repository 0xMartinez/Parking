package com.project.Parking.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {

    @Test
    void setParkingSpaceId() {
        Reservation reservation = new Reservation();
        reservation.setParkingSpaceId("1-1");
        String response = reservation.getParkingSpaceId();
        assertEquals("1-1", response);
    }

    @Test
    void setCustomerId() {
        Reservation reservation = new Reservation();
        reservation.setCustomerId("abc");
        String response = reservation.getCustomerId();
        assertEquals("abc", response);
    }
}