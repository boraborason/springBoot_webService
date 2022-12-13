package com.sbr.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트의 자동 설정, 빈 읽기, 생성을 모두 자동설정(메인 클래스)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
