package com.billies_works.javaweb.chapter17.bean;

public class ItemBean {
	private String id;
	private String name;
	private int price;

	public String getId() { return this.id;	}
	public void setId(String id) { this.id = id; }
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
	public int getPrice() { return this.price; }
	public void setPrice(int price) { this.price = price; }

	public String toString() {
		String itemText = "id:" + this.id
			+ " name:" + this.name
			+ " price" + String.valueOf(this.price);
		return itemText;
	}
}

// 修正時刻： Mon Mar 23 04:46:41 2020
