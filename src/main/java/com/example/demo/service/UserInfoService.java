package com.example.demo.service;

import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserInfoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    public UserInfoService() {
    }
    final static Logger logger = LogManager.getLogger(UserInfoService.class);
    UserInfoRepository userInfoRepository;

    @Autowired
    public void setUserInfoRepository(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }
    private ObjectMapper mapper;

}
