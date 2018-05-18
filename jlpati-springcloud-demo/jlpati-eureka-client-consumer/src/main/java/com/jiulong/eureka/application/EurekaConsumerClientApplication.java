package com.jiulong.eureka.application;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * eureka client starter
 *
 * @author kaishui
 */
@Configuration
@ComponentScan({"com.jiulong"})
@EnableAutoConfiguration
@EnableCircuitBreaker
@SpringBootApplication
@EnableHystrixDashboard
public class EurekaConsumerClientApplication {

    /**
     * spring eureka server 启动入口
     *
     * @param args
     */
    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaConsumerClientApplication.class).web(true).run(args);
    }
}
