package com.ligf.authserver.service.impl;

import com.ligf.authserver.domain.LoginUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName UserServiceImpl
 * @Description 返回数据库中用户的信息（账号，密码）
 * @Author GarmentLee
 * @Date 2025/2/26 17:06
 */
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //实际开发中，这里应该从数据库中查询，返回对应用户名的用户信息
        LoginUserInfo loginUserInfo = new LoginUserInfo();
        loginUserInfo.setUsername(username);
        loginUserInfo.setPassword(passwordEncoder.encode("123456111"));
        /**
         * 权限数据
         */
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ADMIN"));
//        loginUserInfo.setAuthorities(authorities);
        return loginUserInfo;
    }
}
/**
 *
 * Spring Security框架用户账号密码验证流程
 * 1、用户发起登录请求
 * 用户在前端页面输入账号密码，然后通过表单提交或者AJAX请求等方式将登录信息发送到后端服务器。通常，登录请求会发送到一个特定的URL，如/login>
 * 2、请求被过滤器链拦截
 * Spring Security会在请求到达目标控制器之前，将请求传递给一系列的过滤器进行处理。其中UsernamePasswordAuthenticationFilter是专门处理基于表单
 * 的用户名和密码登录的过滤器。
 * 3、提取用户输入的账号和密码
 * UsernamePasswordAuthenticationFilter会从请求中提取用户输入的账号和密码。默认情况下，它会从请求的username和password参数中获取这些信息。
 * 4、调用UserDetailsService加载用户信息
 * UsernamePasswordAuthenticationFilter会创建一个UsernamePasswordAuthenticationToken对象，其中包含用户输入的账号和密码。然后会将这个对象
 * 传递给AuthenticationManager进行验证。
 * AuthenticationManager会调用UserDetailsService来加载与用户输入的账号对应的用户信息。
 * UserDetailsService 是一个接口，需要我们自己实现，用于从数据库或其他数据源中加载用户信息。
 * 5、使用PasswordEncoder验证密码
 * AuthenticationManager 会使用 PasswordEncoder 对用户输入的密码进行加密，并与从 UserDetailsService 中加载的用户信息中的密码进行比较。如果两者匹配，则验证成功；否则，验证失败。
 * PasswordEncoder的passwordEncoder.matches(rawPassword, encodedPassword)进行验证，其中用户输入的密码对应rawPassword(未加密的密码)，
 * 数据库加载的密码作为encodedPassword（加密的密码）。
 *
 *
 */