package com.abinash.unittesting.unittesting.controller;

import com.abinash.unittesting.unittesting.business.ItemBusinessService;
import com.abinash.unittesting.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService itemBusinessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
        final MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();

        JSONAssert.assertEquals("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}", mvcResult.getResponse().getContentAsString(), true);
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {

        when(itemBusinessService.retriveHardCodedItem()).thenReturn(new Item(2,"Item2",10,30));

        RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service").accept(MediaType.APPLICATION_JSON);
        final MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:2, name:Item2, price:10, quantity:30}"))
                .andReturn();

        JSONAssert.assertEquals("{id:2, name:Item2, price:10, quantity:30}", mvcResult.getResponse().getContentAsString(), true);
    }

    @Test
    public void retriveAllItems_basic() throws Exception {

        when(itemBusinessService.retriveAllItems()).thenReturn(Arrays.asList(new Item(2,"Item2",10,30)));

        RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database").accept(MediaType.APPLICATION_JSON);
        final MvcResult mvcResult = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("[{id:2, name:Item2, price:10, quantity:30}]"))
                .andReturn();

        //JSONAssert.assertEquals("{id:2, name:Item2, price:10, quantity:30}", mvcResult.getResponse().getContentAsString(), true);
    }
}
