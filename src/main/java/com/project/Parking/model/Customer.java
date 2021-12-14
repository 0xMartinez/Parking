package com.project.Parking.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @NotBlank
    @Size(min = 3, max = 20)
    private String customerId;


    @OneToMany(mappedBy = "customer", cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    //@ApiParam(hidden = true)
    @JsonManagedReference
    public List<Reservation> getReservations() {
        return reservations;
    }
    @JsonManagedReference
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Customer(String id){
        this.customerId = id;
    }

}
