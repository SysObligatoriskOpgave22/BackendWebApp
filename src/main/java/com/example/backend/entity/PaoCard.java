package com.example.backend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PaoCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Card card;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Pao pao;

    public PaoCard(Card card, Pao pao) {
        this.card = card;
        this.pao = pao;
    }
}
