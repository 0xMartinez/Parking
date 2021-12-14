package com.project.Parking.controller;


import com.project.Parking.dto.ParkingSpaceDTO;
import com.project.Parking.model.ParkingSpace;
import com.project.Parking.service.ParkingSpaceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/parking")
public class ParkingController {

    ParkingSpaceService parkingSpaceService;

    @ApiOperation(value = "Add parking space", notes = "provide information about parking space")
    @PostMapping(value = "/add")
    public ParkingSpace addParkingSpace(ParkingSpace parkingSpace){
        return parkingSpaceService.addParkingSpace(parkingSpace);
    }
    @ApiOperation(value = "List free parking spaces")
    @GetMapping(value = "/list")
    public List<ParkingSpaceDTO> getParkingSpaces() {
        return parkingSpaceService.getFreeParkingSpaces();
    }







}
