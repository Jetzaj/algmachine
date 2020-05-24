package com.algmachine.unittest;

import com.algmachine.AlgMachineApplication;
import com.algmachine.service.proxy.RealSubject;
import com.algmachine.service.proxy.cglib.RealSubjectCglibProxy;
import com.algmachine.service.proxy.jdk.RealSubjectDynamicProxy;
import com.algmachine.service.proxy.jdk.RealSubjectStaticProxy;
import com.algmachine.service.proxy.Subject;
import com.algmachine.service.sort.IArraySort;
import com.algmachine.service.sort.QuickSort;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


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

//    @Ignore
    @Test
    public void test_get_interface() {
        //AnnotatedType[] annotatedTypes =  RealSubject.class.getAnnotatedInterfaces();
//        String abc = "ABC";
//        int num = abc.charAt(1) - 'A' + 1;
//        abc.length();
        int n = 26;
//        char c = (char) ('A' + n - 1);
        int m = 1000 / 26;

        int A = 60;
        int B = 13;

        //System.out.println(A|B);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 0; i< queue.size(); i++){
            Integer first =  queue.poll();
            if (first == 1){
                queue.add(2);
                queue.add(3);
            }
            System.out.println(first);
        }



//        StringBuilder sb = new StringBuilder();
//        while (n > 0) {
//            int c = n % 26;
//            sb.insert(0, (char) ('A' + c - 1));
//            n /= 26;
//        }
//        return sb.toString();

//        System.out.println(sb.toString());
    }

    @Ignore
    @Test
    public void test_cglib_proxy_method() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new RealSubjectCglibProxy());

        Subject realSubject = (RealSubject) enhancer.create();
        System.out.println(realSubject.request());
    }



    @Test
    public void test_sort() {
        int[] arr = {0, 7, 8, 10, 34};
        IArraySort sort = new QuickSort();
        int[] quickSort = sort.sort(arr);
        System.out.println("121212");
    }

}
