package com.jiulong.eureka.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * 测试熔断
 *
 */
@Component
public class StoreIntegration {

    @HystrixCommand(fallbackMethod = "defaultStores", commandProperties = {
            @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
    })
    public String getStores(Map<String, Object> parameters) {
        new RuntimeException("runtime exception");
        return "getStores";
    }

    public String defaultStores(Map<String, Object> parameters) {

        return "defaultStores";
    }
}