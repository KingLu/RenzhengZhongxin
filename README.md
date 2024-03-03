# README.md

## 项目名称
RenzhengZhongxin

## 项目描述
这是一个基于Java和Spring Boot的OAuth 2.0认证中心演示项目，用于展示一个单点登录的demo。该项目为JupyterLab、Nextcloud和GitLab提供单点登录服务。

## 技术栈
- Java 11
- Spring Boot 3.2.3
- Maven
- OAuth 2.0
- H2 Database
- Lombok

## 如何运行
1. 确保您的系统已安装Java 11和Maven。
2. 克隆此仓库到本地。
3. 在项目根目录下运行`mvn clean install`命令，以构建项目。
4. 运行`mvn spring-boot:run`命令，以启动项目。

## 功能
- 提供OAuth 2.0认证服务。
- 支持JupyterLab、Nextcloud和GitLab的单点登录。

## 注意事项
- 本项目使用H2数据库，适用于开发和测试环境，不建议在生产环境中使用。
- 本项目使用Lombok库来简化Java代码，需要在IDE中安装Lombok插件才能正确显示和编辑。

## 贡献
欢迎提交Pull Request或提出Issue。

## 许可证
请查看LICENSE文件了解详细信息。


## 项目结构
RenzhengZhongxin  
├── src  
│   ├── main  
│   │   ├── java  
│   │   │   └── com  
│   │   │       └── abchina  
│   │   │           └── taihang  
│   │   │               └── RenzhengZhongxin  
│   │   │                   ├── RenzhengZhongxinApplication.java  
│   │   │                   ├── OAuth2Controller.java  
│   │   │                   ├── WebSecurityConfig.java  
│   │   │                   ├── HomeController.java  
│   │   │                   └── ServletInitializer.java  
│   │   ├── resources  
│   │   │   ├── static   
│   │   │   ├── templates  
│   │   │   │   ├── index.html  
│   │   │   │   └── welcome.html  
│   │   │   └── application.properties  
│   │   └── webapp  
│   └── test  
├── pom.xml  
└── README.md  
