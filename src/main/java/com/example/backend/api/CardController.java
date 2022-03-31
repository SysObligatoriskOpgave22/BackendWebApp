package com.example.backend.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardController {
    // import and remove comment tags when missing classes are implemented
    //
    //private final CardService cardservice;
    /*
    @GetMapping()
    public List<Card> getCards() {
        return cardService.getcards;
    }

    @GetMapping("/random")
    public List<Card> getCardsRandomized() {
        return cardService.getCardsRandomized;
    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable String id) {
        return cardService.getCard;
    }
    */
}
