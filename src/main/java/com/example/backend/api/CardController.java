package com.example.backend.api;

import com.example.backend.dto.CardResponse;
import com.example.backend.entity.PaoCard;
import com.example.backend.service.CardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    // import and remove comment tags when missing classes are implemented
    //
    private final CardService cardService;

    public CardController(CardService cardservice) {
        this.cardService = cardservice;
    }
    /*
    @GetMapping()
    public List<Card> getCards() {
        return cardService.getcards;
    }

     */

    @GetMapping("/random")
    public List<CardResponse> getCardsRandomized() {
        return cardService.shuffledDeck();
    }
/*
    @GetMapping("/{id}")
    public Card getCard(@PathVariable String id) {
        return cardService.getCard;
    }

 */

}
