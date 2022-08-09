package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.model.LikeStatus;
import com.example.socialnetworkbe.repository.LikeStatusRepository;
import com.example.socialnetworkbe.service.LikeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LikeStatusServiceImpl implements LikeStatusService {
    @Autowired
    private LikeStatusRepository likeStatusRepository;

    @Override
    public void save(LikeStatus likeStatus) {
        likeStatusRepository.save(likeStatus);
    }

    @Override
    public Optional<LikeStatus> findById(Long id) {
        return likeStatusRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        likeStatusRepository.deleteById(id);
    }

    @Override
    public Iterable<LikeStatus> findAll() {
        return likeStatusRepository.findAll();
    }

    @Override
    public LikeStatus findByUserLikeIdAndAndStatusId(Long userID, Long statusId) {
        return likeStatusRepository.findByUserLikeIdAndAndStatusId(userID,statusId);
    }

    @Override
    public Integer findNumberOfLikeByStatus(Long statusId) {
        return likeStatusRepository.findNumberOfLikeByStatus(statusId);
    }
}
