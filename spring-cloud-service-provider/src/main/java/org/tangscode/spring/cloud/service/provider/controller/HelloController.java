package org.tangscode.spring.cloud.service.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "This message is from service-provider";
    }

    @GetMapping("/info")
    public String info() {
        return "This is service-provider, running on port: " + port;
    }
}
