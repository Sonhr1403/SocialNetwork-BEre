package com.example.socialnetworkbe.service;

import com.example.socialnetworkbe.model.LikeStatus;
import com.example.socialnetworkbe.model.Relationship;

import java.util.Optional;

public interface LikeStatusService {
    void save(LikeStatus likeStatus);

    Optional<LikeStatus> findById(Long id);

    void delete(Long id);

    Iterable<LikeStatus> findAll();

    LikeStatus findByUserLikeIdAndAndStatusId(Long userID,Long statusId);

}
