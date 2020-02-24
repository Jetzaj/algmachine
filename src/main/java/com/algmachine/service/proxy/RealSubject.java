package com.algmachine.service.proxy;

public class RealSubject implements Subject {
    @Override
    public String request() {
        return "真实的用户请求";
    }
}
