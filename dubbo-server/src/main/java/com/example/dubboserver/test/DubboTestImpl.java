package com.example.dubboserver.test;

import com.alibaba.fastjson.JSONObject;
import com.test.entity.Book;
import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;
import com.example.dubboserver.test.mapper.BookMapper;


@Service(version = "1.0",interfaceClass = DubboTest.class, timeout = 2000, //接口级别超时时间
    methods = {
        @Method(name = "sayHello", timeout = 1000)//方法级别超时时间
    },retries = 2,weight = 100, loadbalance = "random"
)
@RefreshScope //动态刷新配置，重要
public class DubboTestImpl implements DubboTest {
    @Autowired
    private BookMapper bookMapper;


    @Value(value = "${test.user}")
    private String userName;

    //动态更新需要用到这个对象
    @Autowired
    private ConfigurableApplicationContext applicationContext;


    @Override
//    @HystrixCommand
    public String sayHello(String str) {
//        if(Math.random() > 0.5){
//            throw new RuntimeException("error");
//        }
//        Book book = bookMapper.selectByPrimaryKey(10);
//        return "from server , i am : " + JSONObject.toJSONString(book);
//        return "from server , i am : " + applicationContext.getEnvironment().getProperty("test.user");

        return "from server , i am : " + userName;
    }
}
