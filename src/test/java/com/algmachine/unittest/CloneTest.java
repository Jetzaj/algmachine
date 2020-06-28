package com.algmachine.unittest;


import com.algmachine.AlgMachineApplication;
import com.algmachine.service.common.clone.ObjectClone;
import com.algmachine.service.common.clone.ObjectPropertyClone;
import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AlgMachineApplication.class)
public class CloneTest {

    @Test
    public void test_clone() throws CloneNotSupportedException {

        //使用 clone 方法 实现深 copy 以及 浅 copy
        ObjectPropertyClone objProperty = new ObjectPropertyClone("propertyA", 1);
        ObjectClone objectA = new ObjectClone("objA", 1, objProperty);
        ObjectClone objectB = (ObjectClone) objectA.clone();
        System.out.println("------------------------");

        //使用序列化方法实现 对象的 copy
        byte[] bytes =  SerializationUtils.serialize(objectA);
        ObjectClone objectC = SerializationUtils.deserialize(bytes);
        System.out.println("---------------------------");

        System.out.println(objectA == objectB);
        System.out.println(objectA == objectC);
        System.out.println(objectA.equals(objectB));
        System.out.println(objectA.equals(objectC));
    }
}
