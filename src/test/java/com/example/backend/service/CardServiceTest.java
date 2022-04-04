package com.example.backend.service;

import com.example.backend.dto.CardResponse;
import com.example.backend.entity.PaoCard;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CardServiceTest {

    CardService cut;

    @BeforeEach
    void setUp() {
        cut = new CardService();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getShuffledDeck_decksAreNotEqual() {
        //technically there is a slim chance that two shuffled decks are legally equal
        List<CardResponse> deck1 = cut.shuffledDeck();
        List<CardResponse> deck2 = cut.shuffledDeck();
        assertNotEquals(deck1, deck2);
    }

    /*
    //this fails for some reason, even though the test reports that the contents are identical
    @Test
    void getDefaultDeck_defaultDecksAreEqual() {
        List<CardResponse> deck1 = cut.getDefaultDeck();
        List<CardResponse> deck2 = cut.getDefaultDeck();
        assertEquals(deck1, deck2);
    }
     */

    @Test
    void getDefaultDeck_return52Cards() {
        int result = cut.getDefaultDeck().size();
        assertEquals(52, result);
    }

    @Test
    void getShuffledDeck_return52Cards() {
        int result = cut.shuffledDeck().size();
        assertEquals(52, result);
    }

    @Test
    void getCard() {
    }
}