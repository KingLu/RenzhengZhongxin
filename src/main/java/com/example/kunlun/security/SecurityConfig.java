package com.example.kunlun.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/", "/static/**","/login","/perform_login" ,"/favicon.ico","/error").permitAll()  // 允许所有用户访问首页和静态资源
                        .anyRequest().authenticated()  // 所有其他请求都需要认证
                )
                .formLogin((form) -> form
                        .loginPage("/login")  // 指定自定义登录页面URL
                        .loginProcessingUrl("/perform_login")  // 指定处理登录请求的URL
                        .defaultSuccessUrl("/welcome", true)  // 登录成功后重定向到首页
                        .failureUrl("/login?error=true")  // 登录失败后重定向到登录页面
                        .permitAll()  // 允许所有用户访问登录页面
                )
                .logout((logout) -> logout
                        .logoutUrl("/perform_logout")  // 指定处理登出请求的URL
                        .logoutSuccessUrl("/login?logout=true")  // 登出成功后重定向到登录页面
                        .deleteCookies("JSESSIONID")  // 删除JSESSIONID cookie
                        .permitAll()  // 允许所有用户访问登出页面
                ); // 使用自定义的UserDetailsService加载用户信息

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
