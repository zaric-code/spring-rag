package com.xunyu.rag.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class RagApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(RagApplication.class);
        application.run(args);
        System.out.println("XunyuRag启动成功");
    }

}
