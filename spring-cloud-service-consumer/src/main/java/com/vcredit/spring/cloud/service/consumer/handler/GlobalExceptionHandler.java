package com.vcredit.spring.cloud.service.consumer.handler;

import com.vcredit.spring.cloud.service.consumer.exception.FeignRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(FeignRpcException.class)
    public ResponseEntity<String> handleFeignRpcException(FeignRpcException e) {
        log.error("Feign RPC Exception: status={}, message={}", e.getStatus(), e.getMessage());
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
