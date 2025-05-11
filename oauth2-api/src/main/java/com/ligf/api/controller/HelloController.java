package com.ligf.api.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ligf.api.controller.service.UserService;
import com.ligf.api.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description TODO
 * @Author GarmentLee
 * @Date 2025/2/27 16:26
 */
@RestController
public class HelloController {

    @Autowired
    UserService userService;

    @SentinelResource(value = "hello")
    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/getUserInfo")
    public String getUserInfo(){
        UserInfoDTO userInfoDTO = userService.getUserInfo();
        return "success, userInfo:" + userInfoDTO.toString();
    }
}
