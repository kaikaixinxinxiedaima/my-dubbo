package com.example.dubboclient.test;


import com.example.dubboserver.test.DubboTest;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // @Reference注解用于引用暴露的服务，version参数则对应服务的版本号
    @Reference(version = "1.0")
    DubboTest dubboTest;

    @RequestMapping("/dubbo")
    public String getUserList(String str) {
        return dubboTest.sayHello(str);
    }
}
