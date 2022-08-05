package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.model.Comment;
import com.example.socialnetworkbe.model.Image;
import com.example.socialnetworkbe.repository.CommentRepository;
import com.example.socialnetworkbe.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService<Comment> {
    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public void remove(Long id) {
        commentRepository.deleteById(id);
    }
}
