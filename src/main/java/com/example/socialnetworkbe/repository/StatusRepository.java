package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query(value = "select * from status order by id desc limit 1", nativeQuery = true)
    Status findLastStatus();

    @Query(value = "select * from status where owner_id = :id and status <> 0", nativeQuery = true)
    Iterable<Status> findAllByOwner(@Param("id") Long id);


    @Query(value = "select * from status where status <> 0", nativeQuery = true)
    Iterable<Status> findAll1();
}
