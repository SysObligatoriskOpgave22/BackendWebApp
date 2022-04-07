package com.example.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // name is necessary, so we can put quotes around "rank" since MySQL considers "rank" to be a reserved keyword
    // columnDefinition is necessary in order to use native MySQL enums instead of just strings
    // MUST be in sync with the enum defined in Rank.java
    @Column(name = "`rank`", columnDefinition = "ENUM('ACE', 'TWO', 'THREE', 'FOUR', 'FIVE', 'SIX', 'SEVEN', 'EIGHT', 'NINE', 'TEN', 'JACK', 'QUEEN', 'KING')")
    @Enumerated(EnumType.STRING)
    private Rank rank;

    // columnDefinition is necessary in order to use native MySQL enums instead of just strings
    // MUST be in sync with the enum defined in Suit.java
    @Column(columnDefinition = "ENUM('HEARTS', 'DIAMONDS', 'CLUBS', 'SPADES')")
    @Enumerated(EnumType.STRING)
    private Suit suit;

    @OneToMany(mappedBy = "card", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<PaoCard> paoCards;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(getId(), card.getId()) && getRank() == card.getRank() && getSuit() == card.getSuit() && Objects.equals(getPaoCards(), card.getPaoCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRank(), getSuit(), getPaoCards());
    }
}
