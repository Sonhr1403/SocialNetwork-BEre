package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.model.LikeComment;
import com.example.socialnetworkbe.repository.LikeCommentRepository;
import com.example.socialnetworkbe.service.LikeCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeCommentServiceImpl implements LikeCommentService {
    @Autowired
    private LikeCommentRepository likeCommentRepository;


    @Override
    public void save(LikeComment likeComment) {
        likeCommentRepository.save(likeComment);

    }

    @Override
    public Optional<LikeComment> findById(Long id) {
        return findById(id);
    }

    @Override
    public void delete(Long id) {
        likeCommentRepository.deleteById(id);

    }

    @Override
    public Iterable<LikeComment> findAll() {
        return likeCommentRepository.findAll();
    }

    @Override
    public LikeComment findByUserLikeIdAndAndCommentId(Long idUser, Long idComment) {
        return likeCommentRepository.findByUserLikeIdAndAndCommentId(idUser,idComment);
    }
}
