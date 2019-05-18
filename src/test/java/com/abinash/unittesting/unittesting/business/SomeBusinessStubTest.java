package com.abinash.unittesting.unittesting.business;

import com.abinash.unittesting.unittesting.data.SomeDataService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SomeDataServiceStub implements SomeDataService {

    @Override
    public int[] retriveAllData() {
        return new int[]{1, 2, 3};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        final int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_zero() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        final int actualResult = business.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void calculateSum_onevalue() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        final int actualResult = business.calculateSum(new int[]{5});
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }
}
