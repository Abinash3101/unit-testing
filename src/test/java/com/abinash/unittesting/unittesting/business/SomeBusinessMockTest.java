package com.abinash.unittesting.unittesting.business;

import com.abinash.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    @InjectMocks
    private SomeBusinessImpl business;

    @Mock
    private SomeDataService dataServiceMock;


    @Test
    public void calculateSum_basic() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{1, 2, 3});
        assertEquals(6, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_zero() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{});
        assertEquals(0, business.calculateSumUsingDataService());
    }

    @Test
    public void calculateSum_onevalue() {
        when(dataServiceMock.retriveAllData()).thenReturn(new int[]{5});
        assertEquals(5, business.calculateSumUsingDataService());
    }
}
