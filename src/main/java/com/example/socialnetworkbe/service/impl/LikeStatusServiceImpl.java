package com.example.socialnetworkbe.service.impl;

import com.example.socialnetworkbe.model.LikeStatus;
import com.example.socialnetworkbe.repository.LikeStatusRepository;
import com.example.socialnetworkbe.service.LikeStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeStatusServiceImpl implements LikeStatusService<LikeStatus> {
    @Autowired
    private LikeStatusRepository likeStatusRepository;

    @Override
    public Integer findNumberOfLikeByStatus(Long statusId) {
        return likeStatusRepository.findNumberOfLikeByStatus(statusId);
    }
}
