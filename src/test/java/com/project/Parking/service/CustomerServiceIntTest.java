package com.project.Parking.service;

import com.project.Parking.model.Customer;
import com.project.Parking.model.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest
class CustomerServiceIntTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerService customerService;
    @MockBean
    private ParkingSpaceService parkingSpaceService;
    @MockBean
    private  ReservationService reservationService;

    @Test
    void testCustomer() throws Exception {
        Customer customer       = new Customer("Tom");
        Reservation reservation = new Reservation("1-1", customer.getCustomerId());
        when(reservationService.setReservation(reservation)).thenReturn(reservation);
        mockMvc.perform(post("http://localhost:8080/reservation/add")).andDo(print()).andExpect(status().isOk());
    }



}