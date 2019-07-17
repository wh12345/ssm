package com.wh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wh.dao.ItemsMapper;
import com.wh.pojo.Items;
import com.wh.pojo.ItemsExample;
@Service("itemsService")
public class ItemsServiceImpl implements ItemsService{
	@Resource(name="itemsMapper")
	private ItemsMapper itemsMapper;

	@Override
	public List<Items> list() {
		ItemsExample example = new ItemsExample();
		List<Items> list = itemsMapper.selectByExampleWithBLOBs(example);
		return list;
	}

	@Override
	public Items queryItemsById(Integer id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}

	@Override
	public void update(Items items) {
		itemsMapper.updateByPrimaryKey(items);		
	}
	
	
}
