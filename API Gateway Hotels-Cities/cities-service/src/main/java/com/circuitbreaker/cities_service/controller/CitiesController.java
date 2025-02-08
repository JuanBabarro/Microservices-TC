package com.circuitbreaker.cities_service.controller;

import com.circuitbreaker.cities_service.dto.CityDTO;
import com.circuitbreaker.cities_service.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    @Autowired
    private ICityService cityService;

    @GetMapping("/hotels")
    public CityDTO getCityAndHotels(@RequestParam String name, @RequestParam String country){
        return cityService.getCitiesHotels(name, country);
    }
}
