package com.circuitbreaker.cities_service.service;

import com.circuitbreaker.cities_service.dto.CityDTO;
import com.circuitbreaker.cities_service.model.City;
import com.circuitbreaker.cities_service.repository.IHotelAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{

    @Autowired
    private IHotelAPI hotelAPI;

    private List<City> cities = new ArrayList<City>();

    @Override
    @CircuitBreaker(name = "hotels-service", fallbackMethod = "fallbackGetCitiesHotel") //Este patrón se aplica acá ya que Ciudad consume Hotel
    @Retry(name = "hotels-service") //Sirve para que este microservicio siga intentando comunicarse con el microservicio Hotel
    public CityDTO getCitiesHotels(String name, String country) {

        //Paso 1: Buscamos la ciudad original
        City city = this.findCity(name, country);

        CityDTO cityDTO = new CityDTO();

            cityDTO.setCity_id(city.getCity_id());
            cityDTO.setName(city.getName());
            cityDTO.setCountry(city.getCountry());
            cityDTO.setContinent(city.getContinent());
            cityDTO.setState(city.getState());
            cityDTO.setHotelList(hotelAPI.getHotelsByCityId(city.getCity_id()));

           //createException(); // Creamos una Exception artificial para pruebas. Si lo habilito el Postman lanza un error.

            return cityDTO;

    }

    public CityDTO fallbackGetCitiesHotel(String name, String country, Throwable throwable) {
        return new CityDTO(9999999L, "Fallido", "Fallido", "Fallido", "Fallido", null);
    }

    public void createException() {
        throw new IllegalArgumentException("Prueba Resilience y Circuit Breaker");
    }


    private City findCity(String name, String country) {

        this.loadCities();
        for(City c : cities){
            if(c.getName().equals(name)){
                if(c.getCountry().equals(country)){
                    return c;
                }
            }
        }
        return null;
    }

    private void loadCities() {

        cities.add(new City( 1L, "Oberá", "South America", "Argentina", "Misiones"));
        cities.add(new City( 3L, "Guadalajara", "North America", "Mexico", "Jalisco"));
        cities.add(new City( 4L, "Mexico City", "North America", "Mexico", "Mexico City"));
        cities.add(new City( 5L, "Medellin", "South America", "Colombia", "Antioquia"));
        cities.add(new City( 6L, "Bogotá", "South America", "Colombia", "Cundinamarca"));
        cities.add(new City( 7L, "Valparaíso", "South America", "Chile", "Valparaiso"));
        cities.add(new City( 8L, "Santiago", "South America", "Chile", "Santiago Metropolitan"));
        cities.add(new City( 9L, "Hevideo", "South America", "Uruguay", "Montevideo"));
        cities.add(new City( 10L, "Asunción", "South America", "Paraguay", "Asunción"));
        cities.add(new City( 11L, "Barcelona", "Europe", "Spain", "Catalonia"));
        cities.add(new City( 12L, "Madrid", "Europe", "Spain", "Community of Madrid"));
        cities.add(new City( 13L, "Monterrey", "North America", "Mexico", "Nuevo León"));
        cities.add(new City( 14L, "Seville", "Europe", "Spain", "Andalucia"));
        cities.add(new City( 15L, "Valencia", "Europe", "Spain", "Valencian Community"));
    }
}
