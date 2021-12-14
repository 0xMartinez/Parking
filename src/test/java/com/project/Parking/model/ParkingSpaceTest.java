package com.project.Parking.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceTest {

    @Test
    void setPlaceNumber() {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setPlaceNumber(1);
        int response = parkingSpace.getPlaceNumber();
        assertEquals(1, response);
    }

    @Test
    void setStorey() {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setStorey(1);
        int response = parkingSpace.getStorey();
        assertEquals(1, response);
    }


    @Test
    void setForDisabled() {
        ParkingSpace parkingSpace = new ParkingSpace();
        parkingSpace.setForDisabled(true);
        boolean response = parkingSpace.isForDisabled();
        assertTrue(response);
    }
}