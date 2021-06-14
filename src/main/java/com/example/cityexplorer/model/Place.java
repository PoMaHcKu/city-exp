package com.example.cityexplorer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Place extends PersistObject<Long> {

    @NotBlank
    private String name;

    @NotNull
    private City city;

    private List<Fact> facts = new ArrayList<>();

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "fk_city")
    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "place")
    public List<Fact> getFacts() {
        return facts;
    }

    public void setFacts(List<Fact> facts) {
        this.facts = facts;
    }
}