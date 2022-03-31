package com.example.backend.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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


    public Pao(String imageUrl, String person, String action, String object) {
        this.imageUrl = imageUrl;
        this.person = person;
        this.action = action;
        this.object = object;
    }
}
