package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.repository.LikeCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeCommentService {
    @Autowired
    private LikeCommentRepository likeCommentRepository;
}
