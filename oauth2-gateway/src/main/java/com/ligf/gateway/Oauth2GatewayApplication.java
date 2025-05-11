package com.ligf.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName Oauth2GatewayApplication
 * @Description 启动类
 * @Author GarmentLee
 * @Date 2025/2/26 22:54
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Oauth2GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(Oauth2GatewayApplication.class, args);
    }
}
