package com.vcredit.spring.cloud.service.consumer.controller;

import com.vcredit.spring.cloud.service.consumer.feign.Provider2Client;
import com.vcredit.spring.cloud.service.consumer.feign.ProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@RestController
public class ConsumerController {

    @Resource
    private ProviderClient providerClient;

    @Resource
    private Provider2Client provider2Client;

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name) {
        return providerClient.hello(name);
    }

    @GetMapping("/provider/info")
    public String getProviderInfo() {
        return providerClient.getProviderInfo();
    }

    @GetMapping("provider2/info")
    public String getProviderInfo2() {
        return provider2Client.getProviderInfo();
    }
}
