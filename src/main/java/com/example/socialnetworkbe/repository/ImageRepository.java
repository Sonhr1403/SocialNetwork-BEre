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

    @Query(value = "select image.image,image.id,image.status_id from image join status s on s.id = image.status_id join user_table u on u.id = s.owner_id\n" +
            "where u.id = :idUser order by s.create_at desc", nativeQuery = true)
    Iterable<Image> findAllImageByUserId(@Param("idUser") Long idUser);

    @Query(value = "select image.image,image.id,image.status_id from image join status s on s.id = image.status_id join user_table u on u.id = s.owner_id\n" +
            "where u.id = :idUser order by s.create_at desc limit 5", nativeQuery = true)
    Iterable<Image> top5ImageByUserId(@Param("idUser") Long idUser);
}
