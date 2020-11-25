package com.example.dubboserver;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDubbo            // 开启基于注解的 dubbo 功能
@MapperScan("com.example.dubboserver.test.mapper")//将项目中对应的mapper类的路径加进来就可以了
@RefreshScope //动态刷新配置，重要
public class DubboServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboServerApplication.class, args);
    }

}
