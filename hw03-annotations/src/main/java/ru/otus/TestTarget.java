package ru.otus;

import ru.otus.annotations.After;
import ru.otus.annotations.Before;
import ru.otus.annotations.Test;

public class TestTarget {

    @Before
    void setUp() {
        System.out.println("setUp = throw RuntimeException");
//        throw new RuntimeException();
    }

    @After
    void after() {
        System.out.println("--after method");
    }


    void buildMessageTest2() {
        System.out.println("--buildMessageTest method2");
    }

    @Test
    void buildMessageTest3() {
        System.out.println("--buildMessageTest method3");
    }

    @Test
    void throwEx() {
        System.out.println("-- method throw exception");
        throw new RuntimeException("runtime exception");
    }

    @Test
    void buildMessageTest4() {
        System.out.println("--buildMessageTest method4");
    }

    @Test
    void buildMessageTest5() {
        System.out.println("--buildMessageTest method5");
    }

    @Test
    void buildMessageTest6() {
        System.out.println("--buildMessageTest method6");
    }
}
