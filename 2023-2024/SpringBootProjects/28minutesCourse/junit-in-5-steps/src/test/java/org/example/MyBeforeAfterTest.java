package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyBeforeAfterTest {

    @Before
    void beforeEach(){
        System.out.println("Before each");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test
    public void test2(){
        System.out.println("test2");
    }

    @Test
    public void test3(){
        System.out.println("test3");
    }

    @After
    public void after(){
        System.out.println("After");
    }
}
