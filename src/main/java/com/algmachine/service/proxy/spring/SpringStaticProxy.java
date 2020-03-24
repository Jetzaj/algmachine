package com.algmachine.service.proxy.spring;

import com.algmachine.service.proxy.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SpringStaticProxy {
    @Resource
    private Subject subject;

    public String request() {
        System.out.println("proxy static start");
        String result = subject.request();
        System.out.println("proxy static end");
        return result;
    }
}
