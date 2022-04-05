package com.example.backend.api;

import com.example.backend.dto.CardResponse;
import com.example.backend.entity.PaoCard;
import com.example.backend.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin
public class CardController {
    // import and remove comment tags when missing classes are implemented
    //
    private final CardService cardService;

    public CardController(CardService cardservice) {
        this.cardService = cardservice;
    }

    //Gets defaultDeck in order
    @GetMapping()
    public List<CardResponse> getCards() {
        return cardService.getDefaultDeck();
    }

    //Gets defaultDeck shuffled
    @GetMapping("/random")
    public List<CardResponse> getCardsRandomized() {
        return cardService.shuffledDeck();
    }

    //Get a card from its ID
    @GetMapping("/{id}")
    public CardResponse getCard(@PathVariable int id) {
        return cardService.getCard(id);
    }
}
