package com.jiulong.eureka.web;

import com.jiulong.eureka.service.impl.StoreIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/test")
public class HystrixController {

    @Autowired
    private StoreIntegration storeIntegration;

    @GetMapping("/store")
    public String getStore() {
        return storeIntegration.getStores(new HashMap<>());
    }
}
