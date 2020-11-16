package com.example.dubboclient.test;


import com.example.dubboclient.test.service.TestService;
import com.example.dubboserver.test.DubboTest;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @Autowired
    private TestService testService;

    @RequestMapping("/dubbo")
    public String getUserList(String str) {
        return testService.sayHello(str);
    }
}
