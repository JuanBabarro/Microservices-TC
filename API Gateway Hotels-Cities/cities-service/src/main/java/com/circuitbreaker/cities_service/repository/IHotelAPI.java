package com.circuitbreaker.cities_service.repository;

import com.circuitbreaker.cities_service.dto.HotelDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotels-service")
public interface IHotelAPI {

    @GetMapping("hotels/{city_id}")
    public List<HotelDTO> getHotelsByCityId(@PathVariable ("city_id") Long city_id);
}
