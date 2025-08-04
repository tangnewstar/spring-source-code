package com.vcredit.spring.cloud.service.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */

@FeignClient(name = "service-provider")
public interface ProviderClient {

    @GetMapping("/hello/{name}")
    String hello(@PathVariable String name);

    @GetMapping("/info")
    String getProviderInfo();
}
