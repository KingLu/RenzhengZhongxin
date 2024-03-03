package com.example.kunlun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index"; // 返回首页模板的名称（不包含.html扩展名）
    }

    @GetMapping("/login")
    public String login() {
        return "login";  // 返回login.html模板
    }
}
