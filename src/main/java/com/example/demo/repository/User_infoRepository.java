package com.example.demo.repository;

import com.example.demo.entity.Adress;
import com.example.demo.entity.User_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface User_infoRepository extends JpaRepository<User_info, UUID> {
}
