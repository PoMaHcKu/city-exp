package com.example.cityexplorer.service;

import com.example.cityexplorer.model.PersistObject;

import java.io.Serializable;

public interface CommonService<T extends PersistObject<ID>, ID extends Serializable> {

    T create(T persist);

    T get(ID id);

    T update(T updated);

    void delete(ID id);

}