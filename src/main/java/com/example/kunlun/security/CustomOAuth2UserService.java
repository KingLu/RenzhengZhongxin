package com.example.kunlun.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private static final Logger log = LoggerFactory.getLogger(CustomOAuth2UserService.class);
    private final DefaultOAuth2UserService delegate = new DefaultOAuth2UserService();

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        log.info("Loading user from OAuth2 provider: {}", userRequest.getClientRegistration().getRegistrationId());

        // 使用默认服务请求用户信息
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 记录从OAuth2提供者返回的原始用户信息
        log.info("Attributes from OAuth2 provider: {}", oAuth2User.getAttributes());

        // 处理用户信息（示例：提取额外字段）
        Map<String, Object> attributes = oAuth2User.getAttributes();
        String username = (String) attributes.get("username"); // 假设OAuth2提供者返回的信息中包含username字段

        // 记录处理后的用户名
        log.info("Processed username: {}", username);

        // 创建具有自定义属性和权限的OAuth2User
        Set<SimpleGrantedAuthority> authorities = Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
        return new DefaultOAuth2User(authorities, attributes, "username"); // "username"是指定哪个属性作为用户的名称
    }
}
