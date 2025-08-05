package com.vcredit.spring.cloud.service.consumer;

import com.vcredit.spring.cloud.service.consumer.config.RandomLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableDiscoveryClient
@LoadBalancerClient(name = "service-provider", configuration = RandomLoadBalanceConfig.class)
public class ServiceConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerApplication.class, args);
    }
}
