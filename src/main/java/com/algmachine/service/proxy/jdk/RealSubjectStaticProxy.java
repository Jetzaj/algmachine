package com.algmachine.service.proxy.jdk;

import com.algmachine.service.proxy.RealSubject;
import com.algmachine.service.proxy.Subject;

public class RealSubjectStaticProxy implements Subject {
    RealSubject realSubject;

    public RealSubjectStaticProxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public String request() {
        System.out.println("代理准备发出的请求");
        String resp = realSubject.request();
        System.out.println("代理已经执行请求");
        return resp;
    }
}
