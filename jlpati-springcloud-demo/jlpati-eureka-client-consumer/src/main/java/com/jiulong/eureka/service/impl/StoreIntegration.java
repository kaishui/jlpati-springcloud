package com.jiulong.eureka.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * 测试熔断
 *
 */
@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores")
    public String getStores(Map<String, Object> parameters) {
        new RuntimeException("runtime exception");
        return "getStores";
    }

    public String defaultStores(Map<String, Object> parameters) {

        return "defaultStores";
    }
}