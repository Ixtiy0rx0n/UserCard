package org.example.repository;

import jakarta.transaction.Transactional;
import org.example.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

    Optional <UserEntity> findByPhoneNumber(String phoneNumber);

    @Transactional
    @Modifying
    @Query("update UserEntity u set u.phone=:phone, u.firstName=:firstName, u.lastName=:lastName where u.id=:id")
    Integer update(Integer id, String firstName, String lastName, String phoneNumber);

    @Transactional
    @Modifying
    @Query("update UserEntity set deletedAt=:date where id=:id")
    Integer delete(Integer id, LocalDateTime date);
}
