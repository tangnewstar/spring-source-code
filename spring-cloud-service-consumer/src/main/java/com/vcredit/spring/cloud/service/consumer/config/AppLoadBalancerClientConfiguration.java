package com.vcredit.spring.cloud.service.consumer.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppLoadBalancerClientConfiguration {

    @Bean
	public ServiceInstanceListSupplier hintBasedServiceInstanceListSupplier(ConfigurableApplicationContext context) {
		return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withHints().withCaching()
				.build(context);
	}
	
}