package com.circuitbreaker.cities_service.service;

import com.circuitbreaker.cities_service.dto.CityDTO;

public interface ICityService {

    public CityDTO getCitiesHotels(String name, String country);

}
