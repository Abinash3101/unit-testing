package com.abinash.unittesting.unittesting.business;

import com.abinash.unittesting.unittesting.data.ItemRepository;
import com.abinash.unittesting.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private ItemBusinessService business;

    @Mock
    private ItemRepository repository;


    @Test
    public void retriveAllItems_basic() {
        when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",10,30),
                new Item(3,"Item3",20,20)));
        List<Item> items = business.retriveAllItems();
        assertEquals(300, items.get(0).getValue());
        assertEquals(400, items.get(1).getValue());
    }

}
