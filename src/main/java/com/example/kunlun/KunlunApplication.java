package com.example.kunlun;

import com.example.kunlun.model.User;
import com.example.kunlun.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class KunlunApplication {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(KunlunApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UserRepository userRepository) {
        return args -> {
            User newUser = new User();
            newUser.setUsername("wangwu");
            newUser.setPassword("$2a$10$xfFCRLYxY50dEwSP8ZklYOux2BJl/HabSVxwtpBb4YuMs7RW4jsYy"); // 注意：实际使用时应加密密码
            newUser.setEnabled(true);
            userRepository.save(newUser);

            // 然后尝试检索
            userRepository.findByUsername("wangwu")
                    .ifPresent(user -> System.out.println("User found: " + user.getUsername()));
        };
    }

}
