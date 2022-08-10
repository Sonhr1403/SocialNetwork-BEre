package com.example.socialnetworkbe.service;

import com.example.socialnetworkbe.model.Image;


import java.util.Optional;

public interface ImageService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    void save(T t);

    void remove(Long id);

    Iterable<Image> findAllByStatus(Long id);

    void deleteAllByStatus(Long statusId);
}
