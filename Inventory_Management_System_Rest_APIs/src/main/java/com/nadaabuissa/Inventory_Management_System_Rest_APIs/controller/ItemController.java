package com.nadaabuissa.Inventory_Management_System_Rest_APIs.controller;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Item;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(Long.valueOf(id));
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @RequestBody Item itemDetails) {
        Item updatedItem = itemService.updateItem(id, itemDetails);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Item> updateItemPartially(@PathVariable Long id, @RequestBody Item itemDetails) {
        Item updatedItem = itemService.updateItemPartially(id, itemDetails);
        return new ResponseEntity<>(updatedItem, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(Long.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}