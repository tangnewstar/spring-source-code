package com.vcredit.spring.cloud.service.consumer.config;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.loadbalancer.core.RandomLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/5
 */
@Configuration
public class RandomLoadBalanceConfig {

    @Bean
    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(
            Environment environment, LoadBalancerClientFactory loadBalancerClientFactory) {
        // 获取服务名实例
        String serviceId = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
        // 返回随机负载实例
        return new RandomLoadBalancer(loadBalancerClientFactory.getLazyProvider(serviceId, ServiceInstanceListSupplier.class), serviceId);
    }
}
