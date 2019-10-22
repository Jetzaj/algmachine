package com.algmachine.unittest;

import com.algmachine.AlgMachineApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgMachineApplication.class)
public class AlgMachine {

    @Test
    public void test_unit_method() {
        System.out.println("hello world");
    }

}
