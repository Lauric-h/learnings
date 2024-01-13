package com.springmsa.roguesquadron.controller;

import com.springmsa.roguesquadron.dao.VehicleDao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import com.springmsa.roguesquadron.model.Type;
import com.springmsa.roguesquadron.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3333")
@RestController
public class MainController {
    @Autowired
    VehicleDao vehicleDao;

    @Operation(summary = "Get all vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the vehicles",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content)})
    @GetMapping(value = "/api/vehicles")
    public List<Vehicle> getAllVehicles() {
        return vehicleDao.findAll();
    }

    @Operation(summary = "Get all vehicles of your type")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the vehicles of your type",
                    content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content)})
    @GetMapping(value = "/api/vehicles/type")
    @ResponseBody
    public List<Vehicle> getAllVehiclesByType(@RequestParam String type) {
        for (Type vehicleType : Type.values()){
           if (Objects.equals(vehicleType.getDisplayValue(), type)) {
               return vehicleDao.findAllByType(vehicleType);
           }
        }
        return vehicleDao.findAll();
    }

    @Operation(summary = "Get vehicle by its id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the vehicle",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Vehicle.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid id",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Persona not found",
                    content = @Content)})
    @GetMapping(value = "/api/vehicles/{id}")
    public Vehicle getVehicleById(@PathVariable int id) {
        return vehicleDao.findById(id);
    }
}
