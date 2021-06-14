package com.example.cityexplorer.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class PersistObject<T extends Serializable> {

    private T id;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }
}