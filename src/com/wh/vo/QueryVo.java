package com.wh.vo;

import java.util.Arrays;
import java.util.List;
import com.wh.pojo.Items;

public class QueryVo {
	private Items items;

	Integer[] ids;
	
	List<Items> itemsList;
	public Items getItems() {
		return items; 
	}
	public void setItems(Items items) {
		this.items = items;
	}
	
	public Integer[] getIds() {
		return ids;
	}
	public void setIds(Integer[] ids) {
		this.ids = ids;
	}	
	public List<Items> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<Items> itemsList) {
		this.itemsList = itemsList;
	}
	@Override
	public String toString() {
		return "QueryVo [items=" + items + ", ids=" + Arrays.toString(ids) + ", itemsList=" + itemsList
		                    + "]";
	}		
}
