package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;

import java.sql.SQLException;
import java.util.NoSuchElementException;

public class BattleService{
    private PokedexRepository repo;

    public BattleService(PokedexRepository repo){
        this.repo = repo;
    }

    public String getWinnerName(Pokemon p1, Pokemon p2) throws SQLException{
        Pokemon pokemon1 = repo.getSingleById(p1.getPokedexNumber());
        Pokemon pokemon2 = repo.getSingleById(p2.getPokedexNumber());

        if (pokemon1 == null || pokemon2 == null) {
            throw new NoSuchElementException("Pokemon not found");
        }

        int stats1 = pokemon1.getTotalStats();
        int stats2 = pokemon2.getTotalStats();
        if (stats1 > stats2) return pokemon1.getName();
        if (stats2 > stats1) return pokemon2.getName();

        return "Draw";
    }

    public void getAdvantage(int id1, int id2){

        


    }




    public String getArchetype(Pokemon pokemon){
        /* TODO */
        return null;
    }
}
