package com.example.backend.configuration;

import com.example.backend.entity.Card;
import com.example.backend.entity.Rank;
import com.example.backend.entity.Suit;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.ArrayList;
import java.util.List;

public class DummyCardConfiguration implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Card card = new Card(Rank.FIVE, Suit.DIAMONDS);

        List<Card> deck = new ArrayList<>();

        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add( new Card(rank, suit) );
            }
        }

        System.out.println(deck);
    }
}
