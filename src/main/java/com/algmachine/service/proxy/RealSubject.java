package com.algmachine.service.proxy;

import org.springframework.stereotype.Service;

@Service
public class RealSubject implements Subject {
    @Override
    public String request() {
        return "真实的用户请求";
    }
}
