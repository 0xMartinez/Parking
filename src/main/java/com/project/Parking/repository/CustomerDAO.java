package com.project.Parking.repository;

import com.project.Parking.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerDAO extends CrudRepository<Customer, String> {

    @Override
    List<Customer> findAll();


}
