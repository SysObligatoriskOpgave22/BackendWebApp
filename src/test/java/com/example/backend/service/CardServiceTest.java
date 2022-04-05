package com.example.backend.service;

import com.example.backend.dto.CardResponse;
import com.example.backend.entity.Suit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
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
    void getShuffledDeck_decksAreNotEqual() {
        //technically there is a slim chance that two shuffled decks are legally equal
        List<CardResponse> deck1 = cut.shuffledDeck();
        List<CardResponse> deck2 = cut.shuffledDeck();
        assertNotEquals(deck1, deck2);
    }

    @Test
    void getDefaultDeck_defaultDecksAreEqual() {
        List<CardResponse> deck1 = cut.getDefaultDeck();
        List<CardResponse> deck2 = cut.getDefaultDeck();
        boolean decksEqual = false;
        for(int i=0; i<deck1.size(); i++) {
            if(deck1.indexOf(i) == deck2.indexOf(i)) {
                decksEqual = true;
            } else decksEqual = false;
        }
        assertTrue(decksEqual);
    }

    //test that the deck holds 13 of each suit
    @ParameterizedTest
    @EnumSource(Suit.class)
    void getDefaultDeck_return13ofEachSuit(Suit suit) {
        List<CardResponse> deck = cut.getDefaultDeck();
        int suitCount = 0;
        for(CardResponse card : deck) {
            if (card.getSuit().equals(suit)) {
                suitCount++;
            }
        }
        assertEquals(13, suitCount);
    }
}