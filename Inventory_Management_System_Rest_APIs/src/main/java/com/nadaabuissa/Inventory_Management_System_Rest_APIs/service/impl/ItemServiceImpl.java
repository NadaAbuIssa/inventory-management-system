package com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.impl;

import com.nadaabuissa.Inventory_Management_System_Rest_APIs.model.Item;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.repository.ItemRepository;
import com.nadaabuissa.Inventory_Management_System_Rest_APIs.service.ItemService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

@Override
public List<Item> getAllItems() {
    return itemRepository.findAll();
}

@Override
public Item getItemById(Long id) {
    return itemRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
}

@Override
public Item updateItem(Long id, Item itemDetails) {
    return itemRepository.findById(id)
            .map(item -> {
                item.setName(itemDetails.getName());
                item.setDescription(itemDetails.getDescription());
                item.setPrice(itemDetails.getPrice());
                item.setQuantity(itemDetails.getQuantity());
                return itemRepository.save(item);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
}

@Override
public Item updateItemPartially(Long id, Item itemDetails) {
    return itemRepository.findById(id)
            .map(item -> {
                if (itemDetails.getName() != null) {
                    item.setName(itemDetails.getName());
                }
                if (itemDetails.getDescription() != null) {
                    item.setDescription(itemDetails.getDescription());
                }
                if (itemDetails.getPrice() != null) {
                    item.setPrice(itemDetails.getPrice());
                }
                if (itemDetails.getQuantity() != 0) {
                    item.setQuantity(itemDetails.getQuantity());
                }
                return itemRepository.save(item);
            })
            .orElseThrow(() -> new ResourceNotFoundException("Item not found with id " + id));
}
@Override
public void deleteItem(Long id) {
    if (!itemRepository.existsById(id)) {
        throw new ResourceNotFoundException("Item not found with id " + id);
    }
    itemRepository.deleteById(id);
}
}
