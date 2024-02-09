package com.example.mockito.mockitodemo;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SomeBusinessImplTest {

    @Test
    public void test(){
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        businessImpl.findTheGreatestFromAllData();
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

}

class DataServiceStub implements DataService{
    @Override
    public int[] retrieveAllData(){
        return new int[] {25, 15, 5};
    }
}

//creating new scenarios...
class DataServiceStub1 implements DataService{
    @Override
    public int[] retrieveAllData(){
        return new int[] {25};
    }
}