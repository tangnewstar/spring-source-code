package com.vcredit.spring.cloud.service.consumer.config;

import com.vcredit.spring.cloud.service.consumer.feign.decoder.CustomFeignErrorDecoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@Configuration
public class FeignConfig {

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomFeignErrorDecoder();
    }
}
