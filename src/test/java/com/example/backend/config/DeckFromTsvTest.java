package com.example.backend.config;

import com.example.backend.entity.*;
import com.example.backend.repositories.CardRepository;
import com.example.backend.repositories.DeckRepository;
import com.example.backend.repositories.PaoCardRepository;
import com.example.backend.repositories.PaoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeckFromTsvTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void createDefaultPaos() {
        List<Pao> paoList = DeckFromTsv.createDefaultPaos();

        assertEquals(52, paoList.size());
        assertInstanceOf(Pao.class, paoList.get(0));
        assertEquals("Bench press", paoList.get(0).getAction());

    }

    //List<PaoCard>

    @Test
    void createDeck() {

        Pao paoOne = new Pao("Arnold Schwarzenegger", "Bench press", "Barbell",
                "https://learningisliving.dk/wp-content/uploads/2021/11/pao-classic-h1.jpg");

        Card cardOne = new Card(Rank.ACE, Suit.HEARTS);


        List<PaoCard> paoCardList = DeckFromTsv.createDeck("src/main/resources/card-data.tsv");

        assertEquals(52, paoCardList.size());
        assertInstanceOf(PaoCard.class, paoCardList.get(0));
        assertEquals(paoOne, paoCardList.get(0).getPao());
        assertEquals(cardOne, paoCardList.get(0).getCard());
    }

}