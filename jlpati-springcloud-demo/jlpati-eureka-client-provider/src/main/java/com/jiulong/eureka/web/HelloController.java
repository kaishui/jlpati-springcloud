package com.jiulong.eureka.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * test consume
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    private Logger logger = LoggerFactory.getLogger(HelloController.class);


    @Autowired
    private EurekaClient discoveryClient;

    public String serviceUrl() {
        InstanceInfo instance = discoveryClient.getNextServerFromEureka("eureka-client-2", false);
        return instance.getHomePageUrl();
    }

    @RequestMapping("/server")
    public String home() {
        return serviceUrl();
    }


    @GetMapping("/world/{id}")
    public String hello(@PathVariable String id){
        logger.debug("hello world:{}", id);
        return id;
    }
}
