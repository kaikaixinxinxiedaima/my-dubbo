package com.example.dubboserver.test;

import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0",interfaceClass = DubboTest.class)
public class DubboTestImpl implements DubboTest {
    @Override
    public String sayHello(String str) {
        return "from server , i am : " + str;
    }
}
