package com.jhons.service;

import com.jhons.model.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonService {
    List<Pokemon> listarPokemones();
    Pokemon registrarPokemon(Pokemon p);
    Pokemon buscarPokemon(Long id);
    Pokemon actualizarPokemon(Pokemon p);
    void eliminarPokemon(Long id);
}
