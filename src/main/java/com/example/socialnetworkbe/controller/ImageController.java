package com.example.socialnetworkbe.controller;

import com.example.socialnetworkbe.model.Image;
import com.example.socialnetworkbe.model.Status;
import com.example.socialnetworkbe.service.ImageService;
import com.example.socialnetworkbe.service.StatusService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @Autowired
    StatusService statusService;


    @GetMapping
    public ResponseEntity<Iterable<Status>> findAllImage() {
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> saveImage(@Valid @RequestBody Image image) {
        imageService.save(image);
        return new ResponseEntity(imageService, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Status> findByIdImage(@PathVariable Long id) {
        return new ResponseEntity(imageService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateImage(@PathVariable Long id, @RequestBody Image image) {
        Optional<Image> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        image.setId(imageOptional.get().getId());
        imageService.save(image);
        return new ResponseEntity(image, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Status> deleteStatus(@PathVariable Long id) {
        Optional<Status> imageOptional = imageService.findById(id);
        if (!imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        imageService.remove(id);
        return new ResponseEntity<>(imageOptional.get(), HttpStatus.NO_CONTENT);
    }
}
