package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.LikeComment;
import com.example.socialnetworkbe.model.LikeStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeCommentRepository extends JpaRepository<LikeComment, Long> {
    LikeComment findByUserLikeIdAndAndCommentId(Long idUser, Long idComment);
    @Query(value = "select count(id) from like_comment where comment_id = :id group by comment_id", nativeQuery = true)
    Integer findNumberOfLikeCommentOfComment(@Param("id") Long commentId);
}
