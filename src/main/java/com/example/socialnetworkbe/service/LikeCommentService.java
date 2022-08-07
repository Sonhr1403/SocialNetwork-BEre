package com.example.socialnetworkbe.service;

import com.example.socialnetworkbe.model.LikeComment;

import java.util.Optional;

public interface LikeCommentService {

    void save(LikeComment likeComment);

    Optional<LikeComment> findById(Long id);

    void delete(Long id);

    Iterable<LikeComment> findAll();

    LikeComment findByUserLikeIdAndAndCommentId(Long idUser, Long idComment);
}
