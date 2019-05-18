package com.abinash.unittesting.unittesting.business;

import com.abinash.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
        /*int sum = 0;
        for(int val: data) {
            sum+=val;
        }
        return sum;*/
    }

    public int calculateSumUsingDataService() {
        int[] data = someDataService.retriveAllData();
        int sum = 0;
        for(int val: data) {
            sum+=val;
        }
        return sum;
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}
