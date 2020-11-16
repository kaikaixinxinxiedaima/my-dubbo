package com.example.dubboserver.test;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0",interfaceClass = DubboTest.class, timeout = 2000, //接口级别超时时间
    methods = {
        @Method(name = "sayHello", timeout = 1000)//方法级别超时时间
    },retries = 2,weight = 100, loadbalance = "random"
)
public class DubboTestImpl implements DubboTest {
    @Override
//    @HystrixCommand
    public String sayHello(String str) {
        if(Math.random() > 0.5){
            throw new RuntimeException("error");
        }
        return "from server , i am : " + str;
    }
}
