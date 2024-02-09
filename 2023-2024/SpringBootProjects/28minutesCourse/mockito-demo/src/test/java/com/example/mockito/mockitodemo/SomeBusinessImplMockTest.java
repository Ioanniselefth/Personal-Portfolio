package com.example.mockito.mockitodemo;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extensions.ExtendsWith;


import static org.mockito.Mockito.*;

//fix imports at home.
@ExtendsWith(MockitoExtension.class)
public class SomeBusinessImplMockTest {

    @Mock
    private DataService dataServiceMock;

    @InjectMocks
    private SomeBusinessImpl businessImpl;

    @Test
    public void test_threevalues(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25,15,5});
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void test_onevalue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {25});
        assertEquals(25, businessImpl.findTheGreatestFromAllData());
    }

    @Test
    public void test_novalue(){
        when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
        assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
    }

}