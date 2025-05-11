package com.ligf.userservice.controller;

import com.ligf.userservice.dto.UserInfoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName UserController
 * @Description 用户Controller
 * @Author GarmentLee
 * @Date 2025/2/28 15:14
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUserInfo")
    public UserInfoDTO getUserInfo(){
        System.out.println("getUserInfo...");
        UserInfoDTO result = new UserInfoDTO();
        result.setId("111");
        result.setUserName("test");
        result.setAddress("guangzhou city");
        return new UserInfoDTO();
    }
}
