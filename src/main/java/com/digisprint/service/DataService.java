package com.digisprint.service;

import java.util.List;

import com.digisprint.beans.Item;

public interface DataService {

	List<Item> getAllItems();

	Item postItem(Item item);

	Item getItemById(int itemId);

}
