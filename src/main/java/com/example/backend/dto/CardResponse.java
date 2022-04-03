package com.example.backend.dto;

import com.example.backend.entity.PaoCard;
import com.example.backend.entity.Rank;
import com.example.backend.entity.Suit;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class CardResponse {
    //ID is not showing in the JSON response
    //could be because none of the PaoCards gets and ID when created in DeckFromTsv
    private Long id;
    private Rank rank;
    private Suit suit;
    private String imageUrl;
    private String person;
    private String action;
    private String object;

    public CardResponse(PaoCard paoCard, boolean includeAll) {
        this.id = paoCard.getId();
        this.rank = paoCard.getCard().getRank();
        this.suit = paoCard.getCard().getSuit();
        this.imageUrl = paoCard.getPao().getImageUrl();
        this.person = paoCard.getPao().getPerson();
        this.action = paoCard.getPao().getAction();
        this.object = paoCard.getPao().getObject();
    }

    public static List<CardResponse> CardFromEntity(List<PaoCard> paoCards){
        return paoCards.stream().map(paoCard-> new CardResponse(paoCard,false)).collect(Collectors.toList());
    }

}
