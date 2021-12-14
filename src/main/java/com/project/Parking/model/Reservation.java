package com.project.Parking.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    private String parkingSpaceId;
    private String customerId;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "customer")
    private Customer customer;


    @OneToOne(mappedBy = "reservation")
    private ParkingSpace parkingSpace;

    public Reservation(String parkingSpaceId, String customerId) {
        this.parkingSpaceId = parkingSpaceId;
        this.customerId = customerId;
    }

    @JsonManagedReference
    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }
    @JsonBackReference
    public Customer getCustomer() {
        return customer;
    }






}
