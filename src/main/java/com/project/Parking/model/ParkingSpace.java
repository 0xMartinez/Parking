package com.project.Parking.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class ParkingSpace {

    @Id
    private String parkingSpaceId;
    private int placeNumber;
    private int storey;
    private boolean forDisabled;


    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "parkingSpace_id")
    private Reservation reservation;

    public ParkingSpace(int placeNumber, int storey, boolean forDisabled) {
        this.placeNumber = placeNumber;
        this.storey = storey;
        this.forDisabled = forDisabled;
    }

    @JsonBackReference
    public Reservation getReservation() {
        return reservation;
    }

}
