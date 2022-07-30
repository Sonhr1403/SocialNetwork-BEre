package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.repository.RelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RelationshipServiceImpl {
    @Autowired
    private RelationshipRepository relationshipRepository;
}
