package com.example.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Pao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String person;
    private String action;
    private String object;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private PaoCard paoCard;


    public Pao(String person, String action, String object, String imageUrl) {
        this.imageUrl = imageUrl;
        this.person = person;
        this.action = action;
        this.object = object;
    }
}
