package com.example.socialnetworkbe.service;


import com.example.socialnetworkbe.model.Relationship;

import java.util.Optional;

public interface RelationshipService {

    void save(Relationship relationship);

    Optional<Relationship> findById(Long id);

    void delete(Long id);

}

