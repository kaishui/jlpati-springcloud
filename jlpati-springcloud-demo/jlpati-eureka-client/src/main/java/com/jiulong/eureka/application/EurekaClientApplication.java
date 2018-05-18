package com.jiulong.eureka.application;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * eureka client starter
 * @author kaishui
 */
@Configuration
@ComponentScan({"com.jiulong"})
@EnableAutoConfiguration
@RestController
@EnableEurekaClient
public class EurekaClientApplication {

    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("eureka-client-2", false);
        return instance.getHomePageUrl();
    }

    @RequestMapping("/")
    public String home() {
        return serviceUrl();
    }

    /**
     * spring eureka server 启动入口
     * @param args
     */
    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }
}
