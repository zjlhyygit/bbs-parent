package com.zjl.user;

import com.alibaba.nacos.api.annotation.NacosProperties;
//import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = "127.0.0.1:8848"))
@MapperScan("com.zjl.user.mapper")
public class UserApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(UserApplication.class, args);

//        while(true) {
//            String userName = applicationContext.getEnvironment().getProperty("user.name");
//            String userAge = applicationContext.getEnvironment().getProperty("user.age");
//            System.err.println("user name :"+userName+"; age: "+userAge);
//            TimeUnit.SECONDS.sleep(1);
//        }
    }


}

