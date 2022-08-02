package com.example.socialnetworkbe.service;

import java.util.Optional;

public interface ImageService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);
}
