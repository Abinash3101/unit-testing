package com.abinash.unittesting.unittesting.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ListMockTest {

    @Mock
    private List<String> mockList;

    @Test
    public void size_basic() {
        when(mockList.size()).thenReturn(5);
        assertEquals(5, mockList.size());
    }

    @Test
    public void returnDiffValues() {
        when(mockList.size()).thenReturn(5).thenReturn(10);
        assertEquals(5, mockList.size());
        assertEquals(10, mockList.size());
    }

    @Test
    public void returnWithParams() {
        when(mockList.get(0)).thenReturn("Abinash");
        assertEquals("Abinash", mockList.get(0));
    }

    @Test
    public void returnWithGenericAnyParams() {
        when(mockList.get(anyInt())).thenReturn("Abinash");
        assertEquals("Abinash", mockList.get(8));
    }

    @Test
    public void verificationBasics() {
        // SUT
        String value1 = mockList.get(0);
        String value2 = mockList.get(1);

        //verify
        verify(mockList).get(0);
        verify(mockList, times(2)).get(anyInt());
        verify(mockList, atLeast(1)).get(anyInt());
        verify(mockList, atMost(2)).get(anyInt());
        verify(mockList, never()).get(2);
        verify(mockList, atLeastOnce()).get(anyInt());
    }

    @Test
    public void argumentCapturing() {
        //SUT
        mockList.add("Something");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList).add(captor.capture());

        assertEquals("Something", captor.getValue());
    }

    @Test
    public void multipleArgumentCapturing() {
        //SUT
        mockList.add("Something1");
        mockList.add("Something2");

        //verification
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mockList, times(2)).add(captor.capture());

        List<String> allValues = captor.getAllValues();

        assertEquals("Something1", allValues.get(0));
        assertEquals("Something2", allValues.get(1));
    }

    @Test
    //Mock the real world action
    public void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //null
        System.out.println(arrayListMock.size()); //0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());//0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());//5
    }

    @Test
    //Retain the real world action, if required override it and watch
    public void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        //System.out.println(arrayListSpy.get(0)); //Exception
        System.out.println(arrayListSpy.size()); //0
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());//2

        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());//5

        arrayListSpy.add("Test3");

        System.out.println(arrayListSpy.size());//5

        verify(arrayListSpy).add("Test3");
    }

    //Note: Google Mockito FAQ
    //https://github.com/in28minutes/spring-unit-testing-with-junit-and-mockito
}
