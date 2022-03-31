package com.example.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne(mappedBy = "pao", fetch = FetchType.LAZY)
    private PaoCard paoCard;


    public Pao(String imageUrl, String person, String action, String object) {
        this.imageUrl = imageUrl;
        this.person = person;
        this.action = action;
        this.object = object;
    }
}
