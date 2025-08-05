package org.tangscode.spring.cloud.service.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/1
 */
// eureka和nacos只能两者选择一个，因为AutoServiceRegistration的实例只能有一个
//@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class, args);
    }
}
