package com.abchina.taihang.RenzhengZhongxin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());

            // 根据不同的状态码返回不同的视图或处理
            if (statusCode == 404) {
                return "error-404";
            } else if (statusCode == 500) {
                return "error-500";
            }
            // 可以根据需要添加更多的错误处理
        }

        // 对于其他错误，或者如果状态码不可用，返回一个通用的错误视图
        return "error";
    }

}
