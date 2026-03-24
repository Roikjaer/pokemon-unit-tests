package com.example.springpokemon;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })


@SpringBootTest
class SpringPokemonApplicationTests {

    @Test
    void contextLoads() {


    }

}
