package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl {
    @Autowired
    private StatusRepository repository;
}
