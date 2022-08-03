package com.example.socialnetworkbe.repository;

import com.example.socialnetworkbe.model.Relationship;
import com.example.socialnetworkbe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

    @Query(value = "select * from relationship where ((user1_id = :id1 and user2_id = :id2) or (user1_id = :id2 and user2_id = :id1)) and status <> 0", nativeQuery = true)
    Relationship findRelationship(@Param("id1") Long id1, @Param("id2") Long id2);

    @Query(value = "select relationship.id, user1_id, user2_id, relationship.status  from user_table join relationship on (user_table.id = relationship.user2_id) or (user_table.id=relationship.user1_id)\n" +
            "where user_table.id = :id and relationship.status = 2", nativeQuery = true)
    Iterable<Relationship> findAllFriendByUserId(@Param("id") Long id);
}