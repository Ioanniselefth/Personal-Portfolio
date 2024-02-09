package org.example;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

public class MyMathTest {

    private MyMath math = new MyMath();

    @Test
    public void calculateSum_ThreeMemberArray(){
        int[] numbers = {1,2,3};
        int result = math.calculateSum(numbers);
        System.out.println(result);
        int expectedResult = 6;
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void calculateSum_EmptyArray(){
        int[] numbers = {};
        int result = math.calculateSum(numbers);
        System.out.println(result);
        int expectedResult = 0;
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void calculateSum_NotEqualValues(){
        int[] numbers = {};
        int result = math.calculateSum(numbers);
        System.out.println(result);
        int expectedResult = 6;
        Assert.assertNotEquals(expectedResult, result);
    }
}