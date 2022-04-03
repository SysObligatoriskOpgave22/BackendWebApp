package com.example.backend.dto;

import com.example.backend.entity.PaoCard;
import com.example.backend.entity.Rank;
import com.example.backend.entity.Suit;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CardResponse {
    private Rank rank;
    private Suit suit;
    private String imageUrl;
    private String person;
    private String action;
    private String object;

    public CardResponse(PaoCard paoCard, boolean includeAll) {
        this.rank = paoCard.getCard().getRank();
        this.suit = paoCard.getCard().getSuit();
        this.imageUrl = paoCard.getPao().getImageUrl();
        this.person = paoCard.getPao().getPerson();
        this.action = paoCard.getPao().getAction();
        this.object = paoCard.getPao().getObject();
    }

    public static List<CardResponse> CardFromEntity(List<PaoCard> paoCards){
        return paoCards.stream().map(paoCard-> new CardResponse(paoCard,true)).collect(Collectors.toList());
    }

}
