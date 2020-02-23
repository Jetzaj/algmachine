package com.algmachine.unittest;

import com.algmachine.AlgMachineApplication;
import com.algmachine.service.proxy.RealSubject;
import com.algmachine.service.proxy.RealSubjectDynamicProxy;
import com.algmachine.service.proxy.RealSubjectStaticProxy;
import com.algmachine.service.proxy.Subject;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgMachineApplication.class)
public class ProxyTest {


//    @Ignore
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
        subject.request();
    }
}
