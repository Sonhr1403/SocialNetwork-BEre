package com.example.socialnetworkbe.service;

import org.springframework.data.repository.query.Param;

public interface LikeStatusService<T> {
    Integer findNumberOfLikeByStatus(Long statusId);
}
