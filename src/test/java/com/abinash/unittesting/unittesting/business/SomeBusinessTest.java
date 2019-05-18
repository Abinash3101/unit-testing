package com.abinash.unittesting.unittesting.business;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SomeBusinessTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        final int actualResult = business.calculateSum(new int[]{1, 2, 3});
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
