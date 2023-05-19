package com.cats.cats.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cat")
public class CatModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    private String temperament;
    private String origin;
    private String life_span;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setTemperament(String temperament) {
        this.temperament = temperament;
    }

    public String getTemperament() {
        return this.temperament;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setLife_span(String life_span) {
        this.life_span = life_span;
    }

    public String getLife_span() {
        return this.life_span;
    }
    
}
