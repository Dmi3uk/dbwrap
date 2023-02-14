package com.daky.registerclientservice.dbwrap.services;

import java.util.List;
import java.util.Optional;

public interface RegisterService<T, R> {

    R create(T entry);

    List<R> getAll();

    Optional<R> getById(long id);

    boolean update(R entry, long id);

    boolean delete(long id);
}

