package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeStatusRepository extends JpaRepository<LikeStatus, Long> {
    LikeStatus findByUserLikeIdAndAndStatusId(Long idUser,Long idStatus);
}
