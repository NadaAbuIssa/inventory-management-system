package com.nadaabuissa.Inventory_Management_System_Rest_APIs.service;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long id);
    Item createItem(Item item);
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Item updateItemPartially(Long id, Item item);
}