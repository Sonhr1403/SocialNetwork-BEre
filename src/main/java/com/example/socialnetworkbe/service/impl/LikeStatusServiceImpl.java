package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.repository.LikeStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeStatusServiceImpl {
    @Autowired
    private LikeStatusRepository likeStatusRepository;
}
