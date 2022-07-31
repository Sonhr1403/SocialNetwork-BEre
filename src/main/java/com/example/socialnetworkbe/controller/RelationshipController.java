package com.example.socialnetworkbe.controller;

import com.example.socialnetworkbe.service.RelationshipService;
import com.example.socialnetworkbe.service.impl.RelationshipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/relationships")
public class RelationshipController {

    @Autowired
    RelationshipServiceImpl relationshipService;



}
