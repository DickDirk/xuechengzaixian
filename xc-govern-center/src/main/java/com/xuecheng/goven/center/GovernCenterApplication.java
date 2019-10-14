package com.xuecheng.goven.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @program: xc_EduService01
 * @description
 * @author: liumengke
 * @create: 2019-08-11 09:42
 **/
@SpringBootApplication
@EnableEurekaServer //表示这是一个eureka服务
public class GovernCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(GovernCenterApplication.class,args);
    }
}
