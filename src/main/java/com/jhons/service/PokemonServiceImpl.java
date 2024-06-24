package com.jhons.service;

import com.jhons.model.Pokemon;
import com.jhons.repository.IPokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    private IPokemonRepository repoPoke;
    @Override
    public List<Pokemon> listarPokemones() {
        return repoPoke.findAll();
    }

    @Override
    public Pokemon registrarPokemon(Pokemon p) {
        return repoPoke.save(p);
    }

    @Override
    public Pokemon buscarPokemon(Long id) {
        return repoPoke.findById(id).orElse(null);
    }

    @Override
    public Pokemon actualizarPokemon(Pokemon p) {
        return repoPoke.save(p);
    }

    @Override
    public void eliminarPokemon(Long id) {
        repoPoke.deleteById(id);
    }
}
