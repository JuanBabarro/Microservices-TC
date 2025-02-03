package com.feign.pokeapi.Repository;

import com.feign.pokeapi.DTO.PokemonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokeapi", url = "https://pokeapi.co/api/v2") // Saco la / de la url ya que el endPoint ya empieza con /
public interface IPokeAPIClient {

    @GetMapping("/pokemon/{pokemonId}")
    public PokemonDTO getPokemonInfo(@PathVariable ("pokemonId") int pokemonId);

}
