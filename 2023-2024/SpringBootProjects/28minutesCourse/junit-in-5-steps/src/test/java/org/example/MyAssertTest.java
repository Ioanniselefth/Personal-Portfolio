package org.example;

import org.junit.Test;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyAssertTest {

    List<String> todos = Arrays.asList("AWS", "Azure", "DevOps");

    @Test
    public void test(){
        boolean test = todos.contains("AWS");

        assertEquals(true, test);
        assertTrue(test);

        assertEquals(3, todos.size());
    }
}
