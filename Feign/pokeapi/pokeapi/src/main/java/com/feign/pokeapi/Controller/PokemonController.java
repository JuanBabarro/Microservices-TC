package com.feign.pokeapi.Controller;

import com.feign.pokeapi.DTO.PokemonDTO;
import com.feign.pokeapi.Repository.IPokeAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    @Autowired
    private IPokeAPIClient pokeAPIClient;

    @GetMapping("/pokemon/{pokemonId}")
    public PokemonDTO getPokemonInfo(@PathVariable ("pokemonId") int pokemonId){
        return pokeAPIClient.getPokemonInfo(pokemonId);
    }

}
