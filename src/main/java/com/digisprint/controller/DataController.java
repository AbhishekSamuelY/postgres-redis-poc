package com.digisprint.controller;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digisprint.beans.Item;
import com.digisprint.repository.RedisRepository;
import com.digisprint.service.DataService;

@RestController
@RequestMapping("/service")
public class DataController {

	private DataService service;
	private RedisRepository repository;

	public DataController(DataService service, RedisRepository repository) {
		this.service = service;
		this.repository = repository;
	}
	
	@Cacheable(key = "mycart")
	@GetMapping(value = "/postgres")
	private List<Item> getAllPostgresItems() {
		return service.getAllItems();
	}
	
	@GetMapping(value = "/postgres/{id}")
	@Cacheable(key = "#id", value = "mycart")
	private Item getPostgresItem(@PathVariable int id) {
		return service.getItemById(id);
	}
	
	
	@PostMapping(value = "/postgres")
	private Item postPostgresItem(@RequestBody Item item) {
		System.out.println(item.getItem());
		return service.postItem(item);
	}
	
	@PostMapping(value = "/redis")
	private Item postRedisItem(@RequestBody Item item) {
		return repository.insertItem(item);
	}
	
	@GetMapping(value = "/redis")
	private List<Item> getAllRedisItems() {
		return repository.getAllItems();
	}
	
}
