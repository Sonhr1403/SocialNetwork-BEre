package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl {
    @Autowired
    private CommentRepository commentRepository;
}
