package com.example.cityexplorer.service;

import com.example.cityexplorer.model.PersistObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.function.Supplier;

import static com.example.cityexplorer.util.ExceptionUtils.createException;

public interface CommonService<T extends PersistObject<ID>, ID extends Serializable> {

    T create(T persist);

    T get(ID id);

    T update(T updated);

    void delete(ID id);

    default void throwIfNotExist(ID id, JpaRepository<T, ID> repo) {
        final Supplier<? extends RuntimeException> ex = createException(
                IllegalArgumentException.class,
                "Unable to update unsaved entity");
        if (id == null) {
            throw ex.get();
        }
        repo.findById(id).orElseThrow(ex);
    }

}