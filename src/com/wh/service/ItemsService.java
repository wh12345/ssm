package com.wh.service;

import java.util.List;

import com.wh.pojo.Items;

public interface ItemsService {
	public List<Items> list();
	
	public Items queryItemsById(Integer id);
	
	public void update(Items items);
}
