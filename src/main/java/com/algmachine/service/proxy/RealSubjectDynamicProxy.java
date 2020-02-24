package com.algmachine.service.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RealSubjectDynamicProxy implements InvocationHandler {
    //被代理对象
    Subject realSubject = null;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //实现懒加载
        //体现出代理一个运行时实例化的特点
        if (realSubject == null) {
             realSubject = new RealSubject();
        }

        System.out.println("动态代理执行方法");
        return method.invoke(realSubject, args);
    }

    public static Subject newProxyInstance() {
        return (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class<?>[]{Subject.class}, new RealSubjectDynamicProxy());
    }
}
