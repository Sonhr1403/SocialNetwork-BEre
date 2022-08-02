package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
    @Query(value = "select * from image where status_id = :id", nativeQuery = true)
    Iterable<Image> findAllByStatus(@Param("id") Long id);
}
