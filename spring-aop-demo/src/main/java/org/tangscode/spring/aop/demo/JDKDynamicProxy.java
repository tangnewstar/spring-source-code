package org.tangscode.spring.aop.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author tangxinxing
 * @version 1.0
 * @description JDK动态代理示例，基于接口的封装
 * @date 2025/8/1
 */
class LogInvocationHandler implements InvocationHandler {
    private final Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK Proxy ===> Before Method:" + method.getName());
        Object result = method.invoke(target, args);
        System.out.println("JDK Proxy ===> After Method:" + method.getName());
        return result;
    }
}

interface UserService {
    void save();
}

class UserServiceImpl implements UserService {

    @Override
    public void save() {
        System.out.println("UserServiceImpl ===> save method executed");
    }
}


public class JDKDynamicProxy {

    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        UserService proxy = (UserService) Proxy.newProxyInstance(
                service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new LogInvocationHandler(service)
        );
        System.out.println("======    Call Directly    ======");
        service.save();
        System.out.println("======    Call Proxy    ======");
        proxy.save();
    }

}
