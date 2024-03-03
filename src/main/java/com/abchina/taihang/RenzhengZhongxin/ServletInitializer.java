package com.abchina.taihang.RenzhengZhongxin;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// 设置应用的主配置类
		return application.sources(RenzhengZhongxinApplication.class);
	}

}
