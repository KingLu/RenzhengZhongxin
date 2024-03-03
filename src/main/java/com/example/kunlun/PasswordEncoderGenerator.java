package com.example.kunlun;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PasswordEncoderGenerator {

    public static void main(String[] args) {
        SpringApplication.run(PasswordEncoderGenerator.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return args -> {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            // 替换"yourpassword"为你想要加密的密码
            String password = "123456";
            String encodedPassword = encoder.encode(password);

            System.out.println("Encoded password: " + encodedPassword);
        };
    }
}
