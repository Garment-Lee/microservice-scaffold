package com.ligf.api.controller.service;

import com.ligf.api.dto.UserInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author GarmentLee
 * @Date 2025/2/28 15:33
 */
@FeignClient(name = "user-service")
public interface UserService {

    @GetMapping("/user/getUserInfo")
    UserInfoDTO getUserInfo();
}
