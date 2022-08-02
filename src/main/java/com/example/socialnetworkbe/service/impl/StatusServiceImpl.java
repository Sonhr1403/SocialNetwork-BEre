package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.model.Status;
import com.example.socialnetworkbe.repository.StatusRepository;
import com.example.socialnetworkbe.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService<Status> {
    @Autowired
    private StatusRepository repository;


    @Override
    public Iterable<Status> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Status> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Status status) {
        repository.save(status);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Status findLastStatus() {
        return repository.findLastStatus();
    }
}
