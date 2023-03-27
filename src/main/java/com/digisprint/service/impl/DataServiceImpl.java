package com.digisprint.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digisprint.beans.Item;
import com.digisprint.repository.PostgresRepository;
import com.digisprint.service.DataService;

@Service
public class DataServiceImpl implements DataService {

	PostgresRepository repository;
	
	public DataServiceImpl(PostgresRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Item> getAllItems() {
		System.out.println("returned from postgress");
		List<Item> items = new ArrayList<>();
		repository.findAll().forEach(items::add);
		return items;
	}

	@Override
	public Item postItem(Item item) {
		System.out.println("saved to postgress");
		return repository.save(item);
	}

	@Override
	public Item getItemById(int itemId) {
		System.out.println("returned from postgress");
		return repository.findById(itemId).get();
	}

}
