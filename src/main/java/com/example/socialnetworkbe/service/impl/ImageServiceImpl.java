package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl {
    @Autowired
    private ImageRepository imageRepository;
}
