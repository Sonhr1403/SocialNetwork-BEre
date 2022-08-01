package com.example.socialnetworkbe.controller;

import com.example.socialnetworkbe.model.Relationship;

import com.example.socialnetworkbe.service.impl.RelationshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/relationships")
public class RelationshipController {

    @Autowired
    RelationshipServiceImpl relationshipService;

//    @PostMapping()
//    public ResponseEntity<Relationship> makeFriend(@RequestBody Relationship relationship){
//
//
//
//    }
}
