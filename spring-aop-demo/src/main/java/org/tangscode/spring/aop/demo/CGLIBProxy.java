package org.tangscode.spring.aop.demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author tangxinxing
 * @version 1.0
 * @description CGLIB动态代理，基于对象的封装
 * @date 2025/8/1
 */
class TransactionInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Start Transaction...");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("Finish Transaction");
        return result;
    }
}

class OrderService {
    public void createOrder() {
        System.out.println("Executing createOrder order");
    }
}

public class CGLIBProxy {
    public static void main(String[] args) {
        // createOrder CGLIB Enhancer
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderService.class);
        enhancer.setCallback(new TransactionInterceptor());

        OrderService proxy = (OrderService) enhancer.create();
        proxy.createOrder();
    }
}
