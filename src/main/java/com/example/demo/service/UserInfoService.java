package com.example.demo.service;

import com.example.demo.dto.UserInfoDTO;
import com.example.demo.entity.Adress;
import com.example.demo.entity.Review;
import com.example.demo.entity.UserInfo;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.repository.UserInfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserInfoService {
    public UserInfoService() {
    }
    final static Logger logger = LogManager.getLogger(UserInfoService.class);
    UserInfoRepository userInfoRepository;

    ReviewRepository reviewRepository;

    AdressRepository adressRepository;
    @Autowired
    public void setAdressRepository(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Autowired
    public void setUserInfoRepository(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }
    private ObjectMapper mapper;


    public Optional<UserInfo> getUserInfo(UUID userId) {
        Optional<UserInfo> userInfo= userInfoRepository.findById(userId);
        UserInfoDTO userInfoDTO;
        if(userInfo.isPresent()){
            userInfoDTO = mapper.convertValue(userInfo, UserInfoDTO.class);
        }
        return userInfo;
    }
    public UserInfoDTO createUserInfo(UserInfoDTO userInfoDTO) {
        UserInfo userInfo=mapper.convertValue(userInfoDTO, UserInfo.class);
        UserInfo userFound= userInfoRepository.save(userInfo);
        return mapper.convertValue(userFound, UserInfoDTO.class);
    }
    public UserInfo updateUserInfo(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }
    public void deleteUserInfo(UUID userId) {
        userInfoRepository.deleteById(userId);
    }

    public UserInfo getUserInfoByEmail(String email) {
        return userInfoRepository.findByEmail(email);
    }
    // que review hizo el usuario?
    public List<Review> getReviewsByUserId(UUID userId) {
        return reviewRepository.findByUserInfoId(userId);
    }
    public Adress getAdressByUserId(UUID userId){
        return adressRepository.findByUserInfoId(userId);
    }





}
