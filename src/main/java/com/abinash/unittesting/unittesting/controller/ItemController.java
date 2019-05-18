package com.abinash.unittesting.unittesting.controller;

import com.abinash.unittesting.unittesting.business.ItemBusinessService;
import com.abinash.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService itemBusinessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {
        return new Item(1, "Ball", 10, 100);
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {
        return itemBusinessService.retriveHardCodedItem();
    }

    @GetMapping("/all-items-from-database")
    public List<Item> allItemsFromDatabase() {
        final List<Item> items = itemBusinessService.retriveAllItems();
        return items;
    }
}
