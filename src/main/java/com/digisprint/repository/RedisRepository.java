package com.digisprint.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.digisprint.beans.Item;

@Repository
public class RedisRepository {

	@Autowired
	private RedisTemplate template;
	
	public Item insertItem(Item item) {
		template.opsForHash().put("mycart", item.getId(), item);
		return item;
	}
	
	public List<Item> getAllItems() {
		return template.opsForHash().values("mycart");
		
	}
	
	public Item findItemById(int id) {
		return (Item) template.opsForHash().get("mycart", id);
	}
	
	public int deleteItemById(int id) {
		template.opsForHash().delete("mycart", id);
		return id;
	}
}
