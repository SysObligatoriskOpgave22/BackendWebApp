package com.example.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

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

    @OneToOne(mappedBy = "pao", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @ToString.Exclude
    private PaoCard paoCard;


    public Pao(String person, String action, String object, String imageUrl) {
        this.imageUrl = imageUrl;
        this.person = person;
        this.action = action;
        this.object = object;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pao)) return false;
        Pao pao = (Pao) o;
        return Objects.equals(getId(), pao.getId()) && Objects.equals(getImageUrl(), pao.getImageUrl()) && Objects.equals(getPerson(), pao.getPerson()) && Objects.equals(getAction(), pao.getAction()) && Objects.equals(getObject(), pao.getObject()) && Objects.equals(getPaoCard(), pao.getPaoCard());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getImageUrl(), getPerson(), getAction(), getObject(), getPaoCard());
    }
}
