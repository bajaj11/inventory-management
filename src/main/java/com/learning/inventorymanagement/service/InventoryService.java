package com.learning.inventorymanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.inventorymanagement.entitiy.Item;
import com.learning.inventorymanagement.repository.ItemRepository;

@Service
public class InventoryService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	public Optional<Item> getItemById(long itemId){
		return itemRepository.findById(itemId);
	}
	
	public void addItem(Item item){
		itemRepository.save(item);
	}
	
	public void updateItemPrice(long itemId, int price) {
		Optional<Item> item = getItemById(itemId);
		Item itemToBeUpdated = item.get();
		itemToBeUpdated.setPrice(price);
		itemRepository.save(itemToBeUpdated);
	}
	
	public void deleteAllRecords() {
		itemRepository.deleteAll();
	}
	
	public void deleteItem(long itemId) {
		Optional<Item> item = getItemById(itemId);
		Item itemToBeDeleted = item.get();
		itemRepository.delete(itemToBeDeleted);
	}
	
}
