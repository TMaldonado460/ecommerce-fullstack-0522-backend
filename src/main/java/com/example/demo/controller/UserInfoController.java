package com.example.demo.controller;

import com.example.demo.dto.UserInfoDTO;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("user_info")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    // CRUD
    @PostMapping()
    public UserInfoDTO createUserInfo(@RequestBody UserInfoDTO userInfo) {
        return userInfoService.createUserInfo(userInfo);
    }

    @GetMapping("{id}")
    public Optional<UserInfo> getUserInfo(@RequestParam UUID id) {
        return userInfoService.getUserInfo(id);
    }

    // TODO Get All

    // TODO Put (Update)

    // TODO delete
}
