package com.algmachine.service.proxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class RealSubjectCglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 拦截器执行开始");
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib 拦截器执行结束");
        return result;
    }
}
