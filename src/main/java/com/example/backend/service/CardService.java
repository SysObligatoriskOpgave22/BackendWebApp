package com.example.backend.service;

import com.example.backend.config.DeckFromTsv;

import com.example.backend.dto.CardResponse;
import com.example.backend.entity.PaoCard;
import org.springframework.stereotype.Service;


import java.util.Collections;
import java.util.List;

@Service
public class CardService {

    public CardService(){}

    //Shuffles the defaultDeck
    public List<CardResponse> shuffledDeck(){
       List<PaoCard> deckToShuffle = DeckFromTsv.createDefaultDeck();
       Collections.shuffle(deckToShuffle);
       return CardResponse.CardFromEntity(deckToShuffle);
    }

    //Returns the defaultDeck in a list of CardResponses
    public List<CardResponse> getDefaultDeck(){
        List<PaoCard> defaultDeck = DeckFromTsv.createDefaultDeck();
        return CardResponse.CardFromEntity(defaultDeck);
    }

    //Get a card from the defaultDeck using an ID
    public CardResponse getCard(int id){
        List<CardResponse> deck = getDefaultDeck();
        System.out.println(deck.toString());
        System.out.println(deck.get(id).toString());
        return deck.get(id);
    }

}
