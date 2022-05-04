package com.example.demo.repository;

import com.example.demo.entity.Adress;
import com.example.demo.entity.Bill;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface BillRepository extends JpaRepository<Bill, UUID> {
    @Query //("SELECT b FROM Bill b WHERE b.user.id = ?1" )
    List<Bill> findAllByUserInfoId(UUID userInfoId);

    //TOMI DECIME SI ESTA BIEN,ME QUIERO MORIR-->NO ES BROMA
    @Query
    List<Bill> findAllByUserInfoIdOrderByDate(UUID userInfoId, Sort sort);

}
