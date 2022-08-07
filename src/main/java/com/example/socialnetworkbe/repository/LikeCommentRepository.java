package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.LikeComment;
import com.example.socialnetworkbe.model.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    LikeComment findByUserLikeIdAndAndCommentId(Long idUser, Long idComment);
}
