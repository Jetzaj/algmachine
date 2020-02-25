package com.algmachine.unittest;

import com.algmachine.AlgMachineApplication;
import com.algmachine.service.proxy.RealSubject;
import com.algmachine.service.proxy.cglib.RealSubjectCglibProxy;
import com.algmachine.service.proxy.jdk.RealSubjectDynamicProxy;
import com.algmachine.service.proxy.jdk.RealSubjectStaticProxy;
import com.algmachine.service.proxy.Subject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.AnnotatedType;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgMachineApplication.class)
public class ProxyTest {


    @Ignore
    @Test
    public void test_static_proxy_method() {
        RealSubject realSubject = new RealSubject();
        Subject subject = new RealSubjectStaticProxy(realSubject);
        subject.request();
    }

    @Ignore
    @Test
    public void test_dynamic_proxy_method() {
        Subject subject = RealSubjectDynamicProxy.newProxyInstance();
        String response = subject.request();
        System.out.println(response);
    }

    @Ignore
    @Test
    public void test_get_interface(){
        AnnotatedType[] annotatedTypes =  RealSubject.class.getAnnotatedInterfaces();
        System.out.println("-----");
    }

    @Ignore
    @Test
    public void test_cglib_proxy_method(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new RealSubjectCglibProxy());

        Subject realSubject = (RealSubject) enhancer.create();
        realSubject.request();
    }

}
