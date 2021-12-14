package com.project.Parking.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void setCustomerId() {
        Customer customer = new Customer("Bob");
        String response = customer.getCustomerId();
        assertEquals("Bob", response);
    }
}