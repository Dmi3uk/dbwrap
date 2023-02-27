package com.daky.registerclientservice.dbwrap.services;

import java.util.List;
import java.util.Optional;

public interface RegisterService<T, R, B> {

    R create(T entry);

    List<R> getAll();

    Optional<R> getById(B id);

    boolean update(R entry, B id);

    boolean delete(B id);
}

