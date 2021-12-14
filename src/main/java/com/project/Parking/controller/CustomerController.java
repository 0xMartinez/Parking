package com.project.Parking.controller;

import com.project.Parking.dto.CustomerDTO;
import com.project.Parking.model.Customer;
import com.project.Parking.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    CustomerService customerService;

    @ApiOperation(value = "Add customer", notes = "provide user ID")
    @PostMapping(value = "/add")
    public String addCustomer( @Valid Customer customer, BindingResult result){
        if(result.hasErrors()){
            return "User id must be 3-20 signs and and at least 1 sign";
        }
        customerService.addCustomer(customer);
        return "Customer is valid";
    }
    @ApiOperation(value = "List all customers")
    @GetMapping(value = "/list")
    public List<CustomerDTO> getCustomer() {
        return customerService.getAllCustomers();
    }
}
