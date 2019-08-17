package com.algmachine.unittest;

import com.algmachine.AlgMachineApplication;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = AlgMachineApplication.class)
public class AlgMachine {

    @Ignore
    @Test
    public void test_unit_method() {
        System.out.println("hello world");
    }

}
