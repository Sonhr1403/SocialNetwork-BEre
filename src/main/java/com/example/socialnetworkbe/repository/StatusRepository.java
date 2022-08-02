package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    @Query(value = "select * from status order by id desc limit 1", nativeQuery = true)
    Status findLastStatus();
}
