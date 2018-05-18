package com.jiulong.eureka.application;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * eureka server starter
 * @author kaishui
 */
@SpringBootApplication
@ComponentScan({"com.jiulong"}) // spring beans scan
@EnableEurekaServer
public class EurekaServerApplication {
    /**
     * spring eureka server 启动入口
     * @param args
     */
    public static void main(String[] args) {

        new SpringApplicationBuilder(EurekaServerApplication.class).web(true).run(args);
    }
}
