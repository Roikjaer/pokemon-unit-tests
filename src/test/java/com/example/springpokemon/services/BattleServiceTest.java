package com.example.springpokemon.services;

import com.example.springpokemon.models.Pokemon;
import com.example.springpokemon.repositories.PokedexRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BattleServiceTest {

    private PokedexRepository mockRepo;
    private BattleService service;

    @BeforeEach
    void setUp() {
        mockRepo = mock(PokedexRepository.class);
        service = new BattleService(mockRepo);
    }

    @Test void getWinner1 () throws SQLException {
        Pokemon p1 = new Pokemon(1, "Charizard", 100, 100, 100, 100, 100, 100, "Fire", "");
        Pokemon p2 = new Pokemon(2, "Blastoise", 50, 50, 50, 50, 50, 50, "Water", "");


        when(mockRepo.getSingleById(1)).thenReturn(p1);
        when(mockRepo.getSingleById(2)).thenReturn(p2);

        String result = service.getWinnerName(p1, p2);

        assertEquals("Charizard", result);
        System.out.println("Winner: " + result);


    }

    @Test void getWinner2 () throws SQLException {
        Pokemon p1 = new Pokemon(1, "WeakMon", 10, 10, 10, 10, 10, 10, "", "");
        Pokemon p2 = new Pokemon(2, "StrongMon", 100, 100, 100, 100, 100, 100, "", "");


        when(mockRepo.getSingleById(1)).thenReturn(p1);
        when(mockRepo.getSingleById(2)).thenReturn(p2);

        String result = service.getWinnerName(p1, p2);

        assertEquals("StrongMon", result);
        System.out.println(result);

    }


    @Test
    void getWinnerName_draw() throws SQLException {

        Pokemon p1 = new Pokemon(1, "Equal1", 50, 50, 50, 50, 50, 50, "", "");
        Pokemon p2 = new Pokemon(2, "Equal2", 50, 50, 50, 50, 50, 50, "", "");

        when(mockRepo.getSingleById(1)).thenReturn(p1);
        when(mockRepo.getSingleById(2)).thenReturn(p2);

        String result = service.getWinnerName(p1, p2);

        assertEquals("Draw", result);
        System.out.println(result);
    }











}