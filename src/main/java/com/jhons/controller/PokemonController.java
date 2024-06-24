package com.jhons.controller;

import com.jhons.model.Pokemon;
import com.jhons.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemons")
public class PokemonController {
    @Autowired
    private PokemonService service;

    @GetMapping
    public ResponseEntity<List<Pokemon>> listarPokemones(){
        return ResponseEntity.ok(service.listarPokemones());
    }

    @PostMapping
    public ResponseEntity<Pokemon> agregarPokemon(@RequestBody Pokemon pokemon){
        Pokemon nuevo = service.registrarPokemon(pokemon);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> buscarPokemon(@PathVariable Long id) {
        Pokemon pokemon = service.buscarPokemon(id);
        return pokemon != null ? ResponseEntity.ok(pokemon) : ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<Pokemon> actualizarPokemon(@RequestBody Pokemon pokemon) {
        Pokemon actualizado = service.actualizarPokemon(pokemon);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPokemon(@PathVariable Long id) {
        service.eliminarPokemon(id);
        return ResponseEntity.noContent().build();
    }

}
