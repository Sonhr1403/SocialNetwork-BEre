package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

    @Query(value = "select * from relationship where ((user1_id = :id1 and user2_id = :id2) or (user1_id = :id2 and user2_id = :id1)) and status <> 0",nativeQuery = true)
    Relationship findRelationship(@Param("id1") Long id1,@Param("id2") Long id2);
}