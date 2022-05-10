package com.example.demo.security.repository;

import com.example.demo.security.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<UserInfo, UUID> {
    @Query
    Optional<UserInfo> findByUsername(String username);

    Optional<UserInfo> findByUsernameAndPassword(String username, String password);


    @Query
    UserInfo findByEmail(String email);
}
