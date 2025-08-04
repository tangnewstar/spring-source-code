package com.vcredit.spring.cloud.service.consumer.feign.decoder;

import com.vcredit.spring.cloud.service.consumer.exception.FeignRpcException;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;

/**
 * @author tangxinxing
 * @version 1.0
 * @description
 * @date 2025/8/4
 */
public class CustomFeignErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        String errorMessage = "";
        try {
            if (response.body() != null) {
                errorMessage += Util.toString(response.body().asReader(Util.UTF_8));
            }
        } catch (IOException e) {}

        switch (response.status()) {
            case 404:
                return new FeignRpcException(404, "Feign RPC call failed, Resource not found: " + errorMessage);
            case 500:
                return new FeignRpcException(500, "Feign RPC call failed, Internal server error: " + errorMessage);
            default:
                return defaultDecoder.decode(s, response);
        }
    }
}
