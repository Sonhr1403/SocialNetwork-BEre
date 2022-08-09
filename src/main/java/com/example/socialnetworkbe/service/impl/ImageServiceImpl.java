package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.model.Image;
import com.example.socialnetworkbe.model.Status;
import com.example.socialnetworkbe.repository.ImageRepository;
import com.example.socialnetworkbe.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService<Image> {
    @Autowired
    private ImageRepository imageRepository;


    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Optional<Image> findById(Long id) {
        return imageRepository.findById(id);
    }

    @Override
    public void save(@RequestBody Image image) {
        imageRepository.save(image);
    }

    @Override
    public void remove(Long id) {
        imageRepository.deleteById(id);
    }

    @Override
    public Iterable<Image> findAllByStatus(Long id) {
        return imageRepository.findAllByStatus(id);
    }

}
