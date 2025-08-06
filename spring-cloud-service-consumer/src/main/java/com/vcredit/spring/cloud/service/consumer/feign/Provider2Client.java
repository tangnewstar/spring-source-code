package com.vcredit.spring.cloud.service.consumer.feign;

import com.vcredit.spring.cloud.service.consumer.config.AppLoadBalancerClientConfiguration;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@FeignClient(name = "service-provider-2")
public interface Provider2Client {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable String name);

    @GetMapping("/info")
    String getProviderInfo();
}
