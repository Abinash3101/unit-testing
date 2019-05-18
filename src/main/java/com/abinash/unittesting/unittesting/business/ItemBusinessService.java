package com.abinash.unittesting.unittesting.business;

import com.abinash.unittesting.unittesting.data.ItemRepository;
import com.abinash.unittesting.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemBusinessService {

    @Autowired
    private ItemRepository repository;

    public Item retriveHardCodedItem() {
        return new Item(2, "Bat", 1000, 5);
    }

    public List<Item> retriveAllItems() {
        List<Item> items = repository.findAll();
        for (Item item : items) {
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
