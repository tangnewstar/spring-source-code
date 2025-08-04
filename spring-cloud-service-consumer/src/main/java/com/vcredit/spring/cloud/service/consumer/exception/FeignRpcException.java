package com.vcredit.spring.cloud.service.consumer.exception;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
public class FeignRpcException extends RuntimeException {
    private final int status; // http status

    public FeignRpcException(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
