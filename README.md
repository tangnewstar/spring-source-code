# spring-source-code
some demos &amp; source code trace for spring projects


#### spring-cloud-loadbalancer

spring-cloud提供的负载均衡器有 `RoundRobinLoadBalancer`，`RandomLoadBalancer`。
通过为不同的Loadbalancer设计不同过滤策略的`ServiceInstanceListSupplier`来实现不同的负载均衡策略。

1. 修改全局负载均衡策略 （替换默认的 `ServiceInstanceListSupplier`实现） 
    - 通过配置实现
    ```yaml
    spring:
      cloud:
        loadbalancer:
          # 配置默认的`ServiceInstanceListSupplier`为zonePreferenceDiscoveryClientServiceInstanceListSupplier，默认值为default，即默认使用discoveryClientServiceInstanceListSupplier
          configurations: zone-preference
    ```
   - 自定义 `ServiceInstanceListSupplier` 单例Bean实现
   ```java
    @Configuration
    public class AppLoadBalancerClientConfiguration {
        @Bean
        public ServiceInstanceListSupplier hintBasedServiceInstanceListSupplier(ConfigurableApplicationContext context) {
            return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withHints().withCaching()
                    .build(context);
        }
    }
    ```
   - `@LoadBalancerClients`注解指定默认配置
   ```java
   @LoadBalancerClients(defaultConfiguration = AppLoadBalancerClientConfiguration.class)
   // 这个配置类不要注册到spring容器中
    public class AppLoadBalancerClientConfiguration {
        @Bean
        public ServiceInstanceListSupplier hintBasedServiceInstanceListSupplier(ConfigurableApplicationContext context) {
            return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withHints().withCaching()
                    .build(context);
        }
    }
   ```
   
2. 服务配置负载均衡策略
   - `@LoadBalancerClient`注解特定的FeignClient负载均衡策略
   ```java
    @LoadBalancerClient(name = "app-server", configuration = AppLoadBalancerClientConfiguration.class)
    ```
   - `@LoadBalancerClients` 注解所有服务的`@LoadBalancerClient`策略

