package com.example.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@Entity
public class Deck {

    @Id
    private Long id;
    private String name;
    private String description;

    public Deck() {

    }
    //Constructor
    public Deck(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
