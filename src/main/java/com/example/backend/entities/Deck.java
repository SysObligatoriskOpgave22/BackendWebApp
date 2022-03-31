package com.example.backend.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Deck {

    @Id
    private int id;
    private String name;
    private String description;

    public Deck() {

    }

    public Deck(int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
