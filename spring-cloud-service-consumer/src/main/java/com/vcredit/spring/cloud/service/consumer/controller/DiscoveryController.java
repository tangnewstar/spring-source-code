package com.vcredit.spring.cloud.service.consumer.controller;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@RestController
@RequestMapping("/discovery")
public class DiscoveryController {

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/{service}/instance")
    public String instance(@PathVariable String service) {
        return discoveryClient.getInstances(service).stream().map(instance
                -> instance.getHost() + ":" + instance.getPort()).collect(Collectors.joining(";"));
    }
}
