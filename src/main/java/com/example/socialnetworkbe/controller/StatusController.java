package com.example.socialnetworkbe.controller;

import com.example.socialnetworkbe.model.Image;
import com.example.socialnetworkbe.model.Status;
import com.example.socialnetworkbe.service.ImageService;
import com.example.socialnetworkbe.service.StatusService;
import com.example.socialnetworkbe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/statuses")
public class StatusController {
    @Autowired
    StatusService statusService;
    @Autowired
    UserService userService;
    @Autowired
    ImageService imageService;

    @GetMapping
    public ResponseEntity<ArrayList<?>> findAll() {
        ArrayList<Iterable> result = new ArrayList<>();
        Iterable<Status> listStatus = statusService.findAll();
        result.add(listStatus);
        ArrayList<Iterable<Image>> listImage = new ArrayList<>();
        for (Status status : listStatus) {
            Iterable<Image> images = imageService.findAllByStatus(status.getId());
            listImage.add(images);
        }
        result.add(listImage);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Status> saveStatus(@Valid @RequestBody Status status) {
        status.setCreateAt(LocalDateTime.now());
        statusService.save(status);
        return new ResponseEntity(statusService.findLastStatus(), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Status> findById(@PathVariable Long id) {
        return new ResponseEntity(statusService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id, @RequestBody Status status) {
        Optional<Status> statusOptional = statusService.findById(id);
        if (!statusOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        status.setId(statusOptional.get().getId());
        statusService.save(status);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Status> deleteStatus(@PathVariable Long id) {
        Optional<Status> statusOptional = statusService.findById(id);
        if (!statusOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusService.remove(id);
        return new ResponseEntity<>(statusOptional.get(), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/find-all-by-user/{id}")
    public ResponseEntity<ArrayList<?>> findAllByUser(@PathVariable Long id) {
        ArrayList<Iterable> result = new ArrayList<>();
        Iterable<Status> listStatus = statusService.findAllByOwner(id);
        result.add(listStatus);
        ArrayList<Iterable<Image>> listImage = new ArrayList<>();
        for (Status status : listStatus) {
            Iterable<Image> images = imageService.findAllByStatus(status.getId());
            listImage.add(images);
        }
        result.add(listImage);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
