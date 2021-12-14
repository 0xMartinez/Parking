package com.project.Parking.service;

import com.project.Parking.dto.CustomerDTO;
import com.project.Parking.repository.CustomerDAO;
import com.project.Parking.exception.ConflictExceptionHandler;
import com.project.Parking.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Component
@AllArgsConstructor
public class CustomerService {


    CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {

        Optional<Customer> optionalCustomer = customerDAO.findById(customer.getCustomerId());
        if ((optionalCustomer.isPresent())) {
            throw new ConflictExceptionHandler("There is already customer with the same ID");
        }
        return customerDAO.save(customer);
    }

    public List<CustomerDTO> getAllCustomers(){
        return customerDAO.findAll()
                .stream()
                .map(this::convertEntityToDTO)
                .collect(Collectors.toList());
    }

    private CustomerDTO convertEntityToDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomerId(customer.getCustomerId());
        customerDTO.setReservations(customer.getReservations());
        return customerDTO;
    }

    /*
    public List<Customer> getCustomer(){

        return customerDAO.findAll();
    }
    */
}
