package com.jiulong.eureka.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * eureka client starter
 * @author kaishui
 */
@Configuration
@ComponentScan({"com.jiulong"})
@EnableAutoConfiguration
@EnableEurekaClient
public class EurekaClientApplication {

    /**
     * spring eureka server 启动入口
     * @param args
     */
    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaClientApplication.class).web(true).run(args);
    }
}
