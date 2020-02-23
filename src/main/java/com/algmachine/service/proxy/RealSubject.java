package com.algmachine.service.proxy;

public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("真实的用户请求");
    }
}
