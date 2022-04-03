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

    public List<CardResponse> shuffledDeck(){
       List<PaoCard> deckToShuffle = DeckFromTsv.createDefaultDeck();
       Collections.shuffle(deckToShuffle);
       return CardResponse.CardFromEntity(deckToShuffle);
    }
}
