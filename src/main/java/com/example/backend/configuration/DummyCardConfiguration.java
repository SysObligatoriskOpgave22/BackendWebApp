package com.example.backend.configuration;

import com.example.backend.entity.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DummyCardConfiguration implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Card card = new Card(Rank.FIVE, Suit.DIAMONDS);
        Pao pao = new Pao("https://placekitten.com/300/300", "kitten", "plays with", "yarn");

        PaoCard paoCard = new PaoCard(card, pao);
    }
}
