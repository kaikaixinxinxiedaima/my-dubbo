package com.example.dubboclient.test.service;

import com.example.dubboserver.test.DubboTest;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    // @Reference注解用于引用暴露的服务，version参数则对应服务的版本号
    @Reference(version = "1.0", timeout = 2000,
            methods = {
                    @Method(name = "sayHello", timeout = 1000)
            }, retries = 2, check = false
    )
    DubboTest dubboTest;

    @HystrixCommand(fallbackMethod = "error")
    public String sayHello(String str) {
        return dubboTest.sayHello(str);
    }

    /**
     * 降级方法
     * 参数列表，返回值要与接口保持一致
     *
     * @param str
     * @return
     */
    public String error(String str) {
        return "调用异常------" + str;
    }
}
