package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.model.Relationship;
import com.example.socialnetworkbe.repository.RelationshipRepository;
import com.example.socialnetworkbe.service.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    private RelationshipRepository relationshipRepository;

    @Override
    public void save(Relationship relationship) {
        relationshipRepository.save(relationship);
    }

    @Override
    public Optional<Relationship>findById(Long id) {
        return relationshipRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        relationshipRepository.deleteById(id);
    }

}
