package com.example.demo.service;

import com.example.demo.dto.UserInfoDTO;
import com.example.demo.entity.Adress;
import com.example.demo.entity.Bill;
import com.example.demo.entity.Review;
import com.example.demo.repository.AdressRepository;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.security.entity.UserInfo;
import com.example.demo.security.repository.IUserRepository;
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
    IUserRepository userInfoRepository;

    ReviewRepository reviewRepository;

    AdressRepository adressRepository;

    BillRepository billRepository;
    @Autowired
    public void setBillRepository(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Autowired
    public void setAdressRepository(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Autowired
    public void setReviewRepository(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Autowired
    public void setUserInfoRepository(IUserRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }
    private ObjectMapper mapper;


    public UserInfoDTO getUserInfo(UUID userId) {
        Optional<UserInfo> userInfo= userInfoRepository.findById(userId);
        UserInfoDTO userInfoDTO = null;
        if(userInfo.isPresent()){
            userInfoDTO = mapper.convertValue(userInfo, UserInfoDTO.class);
        }
        return userInfoDTO;
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

    //Direcciones del usuario
    public Adress getAdressByUserId(UUID userId){
        return adressRepository.findByUserInfoId(userId);
    }


    //Historial de compra del usuario
    public List<Bill> getAllBillsByUserId(UUID userId){
        return billRepository.findAllByUserInfoId(userId);
    }






}
