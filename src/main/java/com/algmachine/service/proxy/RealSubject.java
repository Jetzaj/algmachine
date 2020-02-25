package com.algmachine.service.proxy;

import com.algmachine.service.proxy.Subject;

public class RealSubject implements Subject {
    @Override
    public String request() {
        return "真实的用户请求";
    }
}
